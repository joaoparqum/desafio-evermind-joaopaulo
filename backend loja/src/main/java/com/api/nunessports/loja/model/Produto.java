package com.api.nunessports.loja.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private BigDecimal preco;
}
