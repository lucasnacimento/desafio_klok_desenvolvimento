package com.desafio.klok.developer.api_a.presentation;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private List<CampoDTO> listaCampos;

}

