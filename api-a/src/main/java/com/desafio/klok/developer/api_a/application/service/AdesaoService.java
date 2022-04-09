package com.desafio.klok.developer.api_a.application.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.desafio.klok.developer.api_a.domain.AdesaoModel;
import com.desafio.klok.developer.api_a.domain.enums.StatusAdesao;
import com.desafio.klok.developer.api_a.infrastructure.exceptions.NaoEncontradoException;
import com.desafio.klok.developer.api_a.infrastructure.repository.AdesaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdesaoService {
    
    @Autowired
    private AdesaoRepository adesaoRepository;

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

    public AdesaoModel cadastrar(AdesaoModel adesaoModel) {
        try {
            adesaoModel.setDataAdesao(LocalDateTime.now());
            adesaoModel.setStatus(StatusAdesao.ATIVA);
            adesaoModel.setValor(new BigDecimal(adesaoModel.getRespostaValorByCampo("adesao.valor")));
            adesaoModel.setQtdParcelas(new Integer(adesaoModel.getRespostaValorByCampo("adesao.qtdParcelas")));
            adesaoModel.setDiaCobranca(new Integer(adesaoModel.getRespostaValorByCampo("adesao.diaCobranca")));
            adesaoModel = adesaoRepository.save(adesaoModel);
        } catch (IllegalArgumentException err) {
            throw new IllegalArgumentException("Falha ao cadastrar essa Adesão!");
        }
        return adesaoModel;
    }




}