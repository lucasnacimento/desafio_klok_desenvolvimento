package com.desafio.klok.developer.api_a.presentation.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.desafio.klok.developer.api_a.domain.enums.StatusAdesao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdesaoDTO {

    private LocalDateTime dataAdesao;
    
    private BigDecimal valor;
    
    private StatusAdesao status;
    
    private ProdutoDTO produtoModel;
    
    private int qtdParcelas;
    
    private int diaCobranca;

    private List<RespostaDTO> listaRespostas;
    
    private List<CobrancaDTO> listaCobrancas;
}

