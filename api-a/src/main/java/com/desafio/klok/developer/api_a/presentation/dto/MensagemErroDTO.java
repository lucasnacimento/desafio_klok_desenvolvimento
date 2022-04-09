package com.desafio.klok.developer.api_a.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MensagemErroDTO {
    
    private String mensagem;
    private int codigo;
}
