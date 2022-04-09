package com.desafio.klok.developer.api_a.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampoDTO {

    private String nome;

    private boolean isObrigatorio;
    
}
