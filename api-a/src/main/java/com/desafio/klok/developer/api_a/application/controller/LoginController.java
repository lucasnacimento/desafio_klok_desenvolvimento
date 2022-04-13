package com.desafio.klok.developer.api_a.application.controller;

import com.desafio.klok.developer.api_a.application.service.LoginService;
import com.desafio.klok.developer.api_a.presentation.dto.LoginDTO;
import com.desafio.klok.developer.api_a.presentation.dto.MensagemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO login){
        MensagemDTO dto;
        HttpStatus httpCode=HttpStatus.OK;
        try {
            dto = loginService.fazerLogin(login);
            return ResponseEntity.status(httpCode).body(dto);
        } catch (Exception e) {
            httpCode = HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(httpCode).body(new MensagemDTO("Credencias inválidas", httpCode.value()));
        }
    }

}
