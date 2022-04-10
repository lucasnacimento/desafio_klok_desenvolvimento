package com.desafio.klok.developer.api_a.application.controller;

import com.desafio.klok.developer.api_a.application.service.AdesaoService;
import com.desafio.klok.developer.api_a.domain.AdesaoModel;
import com.desafio.klok.developer.api_a.presentation.dto.AdesaoDTO;
import com.desafio.klok.developer.api_a.presentation.dto.MensagemErroDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desafio.klok.developer.api_a.infrastructure.exceptions.NaoEncontradoException;

@RestController
@RequestMapping("/adesao")
public class AdesaoController {
    
    @Autowired
    private AdesaoService adesaoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody AdesaoDTO adesaoDTO) {
        AdesaoModel adesaoModel = modelMapper.map(adesaoDTO, AdesaoModel.class);
        HttpStatus httpCode = HttpStatus.CREATED;
        try {
            adesaoModel = adesaoService.cadastrar(adesaoModel, adesaoDTO.getIdProdutoModel());
            AdesaoDTO dto = modelMapper.map(adesaoModel, AdesaoDTO.class);
            return ResponseEntity.status(httpCode).body(dto);
        
        } catch (IllegalArgumentException e) {
            httpCode = HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(httpCode).body(new MensagemErroDTO(e.getMessage(), httpCode.value()));
        
        } catch (NaoEncontradoException e) {
            httpCode = HttpStatus.NOT_FOUND;
            return ResponseEntity.status(httpCode).body(new MensagemErroDTO(e.getMessage(), httpCode.value()));
        }
    }

}