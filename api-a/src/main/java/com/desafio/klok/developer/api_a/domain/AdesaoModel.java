package com.desafio.klok.developer.api_a.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.desafio.klok.developer.api_a.domain.enums.StatusAdesao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_adesao")
public class AdesaoModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "data_adesao")
    private LocalDateTime dataAdesao;
    
    private BigDecimal valor;
    
    private StatusAdesao status;
    
    @Column(name = "produto_model")
    private ProdutoModel produtoModel;
    
    @Column(name = "qtd_parcelas")
    private int qtdParcelas;
    
    @Column(name = "dia_cobranca")
    private int diaCobranca;

    @JoinColumn(name = "id_resposta")
    @OneToMany(cascade = CascadeType.ALL)
    private List<RespostaModel> listaRespostas;
    
    @JoinColumn(name = "id_cobranca")
    @OneToMany(cascade = CascadeType.ALL)
    private List<CobrancaModel> listaCobrancas;
}
