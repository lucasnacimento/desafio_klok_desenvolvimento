package com.desafio.klok.developer.api_a.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CredenciaisDTO {
    
    private String login;

    private String password;
}
