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
import javax.persistence.ManyToOne;
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

    @Column(name = "data_adesao")
    private LocalDateTime dataAdesao;
    
    private BigDecimal valor;
    
    private StatusAdesao status;
    
    @JoinColumn(name = "id_produto")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProdutoModel produtoModel;
    
    @Column(name = "qtd_parcelas")
    private int qtdParcelas;
    
    @Column(name = "dia_cobranca")
    private int diaCobranca;

    @JoinColumn(name = "id_adesao")
    @OneToMany(cascade = CascadeType.ALL)
    private List<RespostaModel> listaRespostas;
    
    @JoinColumn(name = "id_adesao")
    @OneToMany(cascade = CascadeType.ALL)
    private List<CobrancaModel> listaCobrancas;

    public String getRespostaValorByCampo(String nomeCampo) {
        return listaRespostas.stream().filter(resposta -> 
            resposta.getCampo().getNome().equals(nomeCampo)     
        ).findFirst().map(res -> res.getValor()).orElse(null);
    }

    public void cadastrar(){
        this.dataAdesao = LocalDateTime.now();
        this.status = StatusAdesao.ATIVA;
        this.valor = this.getProdutoModel().getPreco();
        this.qtdParcelas = new Integer(this.getRespostaValorByCampo("adesao.qtdParcelas"));
        this.diaCobranca = new Integer(this.getRespostaValorByCampo("adesao.diaCobranca"));
    }
    
}
