package com.desafio.klok.developer.api_a.presentation.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaDTO {

    private CampoDTO campo;

    @NotBlank(message="O campo de resposta é obrigatório!")
    private String valor;

}
