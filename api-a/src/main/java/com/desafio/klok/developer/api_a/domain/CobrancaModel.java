package com.desafio.klok.developer.api_a.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_cobranca")
public class CobrancaModel implements Serializable{

    private static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_cobranca")
    private BigDecimal valor;

    @Column(name = "data_cobranca")
    private LocalDateTime dataCobranca;

    @Column(name = "id_adesao")
    private Long id_adesao;

    @JoinColumn(name = "id_pagamento")
    @OneToOne(cascade = CascadeType.ALL)
    private PagamentoModel pagamento;

    public void cadastrarCobranca(BigDecimal valor, AdesaoModel adesao){
        LocalDateTime dataAutal = LocalDateTime.now();
        int mes = (dataAutal.getMonth().getValue() == 12) ? 1 : dataAutal.getMonth().getValue()+1;
        this.dataCobranca = LocalDateTime
                .of(dataAutal.getYear(), mes, adesao.getDiaCobranca()
                , dataAutal.getHour(), dataAutal.getMinute());
        this.valor = valor;
    }
}
