package com.desafio.klok.developer.api_a.application.service;

import java.util.List;
import java.util.Optional;

import com.desafio.klok.developer.api_a.domain.ProdutoModel;
import com.desafio.klok.developer.api_a.infrastructure.exceptions.EncontradoException;
import com.desafio.klok.developer.api_a.infrastructure.exceptions.NaoEncontradoException;
import com.desafio.klok.developer.api_a.infrastructure.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> buscar() throws NaoEncontradoException {
        List<ProdutoModel> lista = produtoRepository.findAll();
        if(lista.isEmpty()){
            throw new NaoEncontradoException("Nenhum produto foi encontrado.");
        }
        return lista;
    }

    public ProdutoModel buscar(Long id) throws NaoEncontradoException {
        Optional<ProdutoModel> produtoOptional = produtoRepository.findById(id);
        if(!produtoOptional.isPresent()){
            throw new NaoEncontradoException("produto de id: ".concat(id.toString()).concat(" não foi encontrado!"));
        }
        return produtoOptional.get();
    }

    public void delete(Long id) throws NaoEncontradoException {
        try {
            produtoRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new NaoEncontradoException("produto de id: ".concat(id.toString()).concat(" não foi encontrado!"));
        }
    }

    public ProdutoModel cadastrar(ProdutoModel produtoModel) throws EncontradoException {
        try {
            Optional<ProdutoModel> produtoOptional = produtoRepository.findByNome(produtoModel.getNome());
            if (produtoOptional.isPresent()) {
               throw new EncontradoException("produto de nome: ".concat(produtoModel.getNome()).concat(" já foi cadastrado anteriormente!"));
            }
            produtoModel = produtoRepository.save(produtoModel);
        } catch (IllegalArgumentException err) {
            throw new IllegalArgumentException("Falha ao cadastrar esse produto!");
        }
        return produtoModel;
    }

}
