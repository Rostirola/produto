package com.example.produtos.controller;

import com.example.produtos.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    public ProdutoController() {
        produtos.addAll(List.of(
                new Produto(1, "Produto 1", "teste", 2.09),
                new Produto(2, "Produto 2", "sdsd", 2.09),
                new Produto(3, "Produto 3", "sdsd", 2.09),
                new Produto(4, "Produto 4", "sdsd", 2.09),
                new Produto(5, "Produto 5", "sdsd", 2.09)
        ));
    }

    @GetMapping("/produtos")
    Iterable<Produto> getProdutos() {
        return produtos;
    }

    @GetMapping("/produtos/{id}")
    Optional<Produto> getProdutoById(@PathVariable Long id) {
        for (Produto p: produtos) {
            if (p.getId() == id) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/produtos")
    Produto postProduto(@RequestBody Produto produto) {
        produtos.add(produto);
        return produto;
    }

    @PutMapping("/produtos/{id}")
    Produto putProduto(@PathVariable Long id, @RequestBody Produto produto) {
        int index = -1;
        for (Produto p: produtos) {
            if (p.getId() == id) {
                index = produtos.indexOf(p);
                produtos.set(index, produto);
                break;
            }
        }
        return (index == -1) ? postProduto(produto) : produto;
    }

    @DeleteMapping("/produtos/{id}")
    void deleteProduto(@PathVariable Long id) {
        produtos.removeIf(p -> p.getId() == id);
    }
}
