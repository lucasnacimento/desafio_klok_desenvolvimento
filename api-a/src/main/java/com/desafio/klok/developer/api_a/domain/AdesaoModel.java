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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.desafio.klok.developer.api_a.domain.enums.StatusAdesao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "t_adesao")
public class AdesaoModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "data_adesao")
    private LocalDateTime dataAdesao;
    
    @NotNull
    private BigDecimal valor;
    
    @NotNull
    @Column(name = "status_adesao")
    private StatusAdesao status;
    
    @NotNull
    @JoinColumn(name = "id_produto")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProdutoModel produtoModel;
    
    @NotNull
    @Column(name = "qtd_parcelas")
    private int qtdParcelas;
    
    @NotNull
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

    public RespostaModel getRespostaByCampo(String nomeCampo) {
        return listaRespostas.stream().filter(resposta -> 
            resposta.getCampo().getNome().equals(nomeCampo)     
        ).findFirst().map(res -> res).orElse(null);
    }

    public void cadastrar(){
        this.dataAdesao = LocalDateTime.now();
        this.status = StatusAdesao.ATIVA;
        this.valor = this.getProdutoModel().getPreco();
        this.qtdParcelas = new Integer(this.getRespostaValorByCampo("adesao.qtdParcelas"));
        this.diaCobranca = new Integer(this.getRespostaValorByCampo("adesao.diaCobranca"));
    }

    public void validarRespostas(){
        List<CampoModel> campos = this.getProdutoModel().getListaCampos();
        List<RespostaModel> respostas = this.getListaRespostas();
        for (CampoModel campo : campos) {
            if (campo.isObrigatorio()) {
                int count = 0;
                for(RespostaModel resposta : respostas) {
                    if(resposta.getCampo().getNome().equals(campo.getNome())) {
                        count++;
                    }
                }
                if(count == 0) {
                    throw new IllegalArgumentException("campo ".concat(campo.getNome()).concat(" é obrigatório!"));
                }
            }
        }
    }   
    
    public void validarProduto(){
        if(produtoModel == null){
            throw new IllegalArgumentException("Adesão não possuí produto!");
        }
    }
    
}
