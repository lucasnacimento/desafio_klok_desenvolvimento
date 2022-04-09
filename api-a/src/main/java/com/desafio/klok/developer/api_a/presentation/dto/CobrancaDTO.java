package com.desafio.klok.developer.api_a.presentation.dto;

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

    private LocalDateTime dataCobranca;

    private PagamentoDTO pagamento;

}

