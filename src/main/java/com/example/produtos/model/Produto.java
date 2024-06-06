package com.example.produtos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Produto {

    private long id;
    private String nome;
    private String descricao;
    private double preco;
}
