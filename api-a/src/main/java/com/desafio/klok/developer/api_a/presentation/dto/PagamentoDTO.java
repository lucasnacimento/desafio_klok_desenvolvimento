package com.desafio.klok.developer.api_a.presentation.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDTO implements Serializable{
    
    private LocalDateTime dataPagamento;

}

