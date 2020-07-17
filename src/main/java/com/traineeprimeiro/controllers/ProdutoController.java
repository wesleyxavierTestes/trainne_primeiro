package com.traineeprimeiro.controllers;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.*;
import com.traineeprimeiro.domain.entities.Produto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    private static ArrayList<Produto> produtos = new ArrayList<Produto>() {{
        add(new Produto(1l, "Sandalha", new BigDecimal(20.00)));
        add(new Produto(2l, "Sapatênis", new BigDecimal(50.00)));
        add(new Produto(3l, "All start", new BigDecimal(110.00)));
    }};

    @GetMapping(path = "/lista")
    public List<Produto> get() {
        return produtos;
    }

    @GetMapping("/consultarPorId/{id}")
    public Produto getPath(@PathVariable int id) {
        for (Produto produto:produtos) {
            if (produto.getId() == id)
            return produto;
        }
        return null;
    }

    @GetMapping(path = "/consultarPorNome")
    public Produto getRequest(@RequestParam(name = "nome") String nome) {
        for (Produto produto:produtos) {
            if (produto.getNome().equals(nome))
                return produto;
        }
        return null;
    }

    @PostMapping(path = "/adicionar")
    public Produto postProduto(@RequestBody Produto produto) {
        produto.setId(produtos.size() + 1);
        produtos.add(produto);
        return produto;
    }

    @PutMapping(path = "/editar")
    public Produto putProduto(@RequestBody Produto produto) {
        for (Produto produtoUpdate : produtos) {
            if (produtoUpdate.getId() == produto.getId()) {
                produtoUpdate.setValor(produto.getValor());
                produtoUpdate.setNome(produto.getNome());
                produto = null;
                break;
            }
        }
        return produto;
    }

    @DeleteMapping(path = "/deletar")
    public Produto deleteProduto(@RequestParam(name = "id") long id) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getId() == id) {
                produtos.remove(i);
                return produto;
            }
        }
        return null;
    }
}