package com.desafio.klok.developer.api_a.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "t_produto")
public class ProdutoModel implements Serializable {

    private static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    @JoinTable(name = "t_produto_campo", 
        joinColumns = @JoinColumn(name = "id_produto"),
        inverseJoinColumns = @JoinColumn(name = "id_campo"))
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<CampoModel> listaCampos;

    public CampoModel buscaCampoNome(String nome){
        return listaCampos.stream().filter(campo -> 
        campo.getNome().equals(nome)     
        ).findFirst().map(p -> p).orElse(null);
    }

}
