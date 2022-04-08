package com.desafio.klok.developer.api_a.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @Column(name = "data_cobranca")
    private LocalDateTime dataCobranca;

    @JoinColumn(name = "id_pagamento")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PagamentoModel pagamento;

}
