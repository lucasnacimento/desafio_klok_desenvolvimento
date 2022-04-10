package com.desafio.klok.developer.api_a.application.controller;

import com.desafio.klok.developer.api_a.application.service.ProdutoService;
import com.desafio.klok.developer.api_a.domain.ProdutoModel;
import com.desafio.klok.developer.api_a.infrastructure.exceptions.NaoEncontradoException;
import com.desafio.klok.developer.api_a.presentation.dto.MensagemErroDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    

    @GetMapping
    public ResponseEntity<?> buscarTodosProdutos() {
        try {
            List<ProdutoModel> listaProdutos = produtoService.buscar();

            return ResponseEntity.status(HttpStatus.CREATED).body(listaProdutos);
        } catch (NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemErroDTO(e.getMessage(), HttpStatus.NOT_FOUND.value()));
        }
    } 

}
