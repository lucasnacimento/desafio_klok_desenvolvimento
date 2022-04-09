package com.desafio.klok.developer.api_a.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.desafio.klok.developer.api_a.domain.AdesaoModel;
import com.desafio.klok.developer.api_a.domain.CampoModel;
import com.desafio.klok.developer.api_a.domain.RespostaModel;
import com.desafio.klok.developer.api_a.infrastructure.exceptions.NaoEncontradoException;
import com.desafio.klok.developer.api_a.infrastructure.repository.AdesaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdesaoService {
    
    @Autowired
    private AdesaoRepository adesaoRepository;
    
    @Autowired
    private ProdutoService produtoService;

    public List<AdesaoModel> buscar() throws NaoEncontradoException {
        List<AdesaoModel> lista = adesaoRepository.findAll();
        if(lista.isEmpty()){
            throw new NaoEncontradoException("Nenhuma Adesão foi encontrada!");
        }
        return lista;
    } 

    public AdesaoModel buscar(Long id) throws NaoEncontradoException {
        Optional<AdesaoModel> produtoOptional = adesaoRepository.findById(id);
        if(!produtoOptional.isPresent()){
            throw new NaoEncontradoException("Adesão de id: ".concat(id.toString()).concat(" não foi encontrada!"));
        }
        return produtoOptional.get();
    }

    public AdesaoModel cadastrar(AdesaoModel adesaoModel, Long idProduto) throws IllegalArgumentException, NaoEncontradoException {
        adesaoModel.setProdutoModel(produtoService.buscar(idProduto));
        recuperarCampos(adesaoModel);
        adesaoModel.validarProduto();
        adesaoModel.validarRespostas();
        try {
            adesaoModel.cadastrar();
            adesaoModel = adesaoRepository.save(adesaoModel);
        } catch (IllegalArgumentException err) {
            throw new IllegalArgumentException("Falha ao cadastrar essa Adesão!");
        }
        return adesaoModel;
    }

    public void recuperarCampos(AdesaoModel adesaoModel) throws NaoEncontradoException { 
        List<RespostaModel>listaRespostasNova = new ArrayList<>(); 
        for (RespostaModel res : adesaoModel.getListaRespostas()) {
            CampoModel campo = adesaoModel.getProdutoModel().buscaCampoNome(res.getCampo().getNome());
            if(campo == null) {
                throw new NaoEncontradoException("Campo ".concat(res.getCampo().getNome()).concat(" Não existe!"));
            }
            RespostaModel resposta = new RespostaModel();
            resposta.setCampo(campo);
            resposta.setValor(res.getValor());
            listaRespostasNova.add(resposta);
        }
        adesaoModel.setListaRespostas(listaRespostasNova);
    }

}
