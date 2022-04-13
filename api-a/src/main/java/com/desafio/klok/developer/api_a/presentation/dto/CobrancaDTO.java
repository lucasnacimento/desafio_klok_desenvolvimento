package com.desafio.klok.developer.api_a.presentation.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CobrancaDTO {

    private Long id;

    private PagamentoDTO pagamento;

    private Long id_adesao;

    private BigDecimal valor;

    private LocalDateTime dataCobranca;
}

