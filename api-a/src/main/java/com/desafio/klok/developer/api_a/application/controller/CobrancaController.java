package com.desafio.klok.developer.api_a.application.controller;

import com.desafio.klok.developer.api_a.application.service.CobrancaService;
import com.desafio.klok.developer.api_a.domain.CobrancaModel;
import com.desafio.klok.developer.api_a.infrastructure.exceptions.NaoEncontradoException;
import com.desafio.klok.developer.api_a.presentation.dto.CobrancaDTO;
import com.desafio.klok.developer.api_a.presentation.dto.MensagemErroDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cobranca")
public class CobrancaController {

    @Autowired
    private CobrancaService cobrancaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody CobrancaDTO cobrancaDTO){
        CobrancaModel cobranca = modelMapper.map(cobrancaDTO, CobrancaModel.class);
        HttpStatus codeStatus;
        try {
            cobranca = cobrancaService.cadastrar(cobranca, cobrancaDTO.getId_adesao());
            codeStatus = HttpStatus.OK;
            cobrancaDTO = modelMapper.map(cobranca, CobrancaDTO.class);
            return ResponseEntity.status(codeStatus).body(cobrancaDTO);

        } catch (NaoEncontradoException e) {
            codeStatus = HttpStatus.NOT_FOUND;
            return ResponseEntity.status(codeStatus).body(new MensagemErroDTO(e.getMessage(),codeStatus.value()));
        }

    }


}
