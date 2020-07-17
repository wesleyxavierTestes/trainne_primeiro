package com.traineeprimeiro.controllers;

import java.math.BigDecimal;
import com.traineeprimeiro.domain.services.produto.ProdutoService;

import com.traineeprimeiro.domain.entities.produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    private static ArrayList<Produto> produtos = new ArrayList<Produto>() {{
        add(new Produto(1l, "Sandalha", new BigDecimal(20.00)));
        add(new Produto(2l, "Sapatênis", new BigDecimal(50.00)));
        add(new Produto(3l, "All start", new BigDecimal(110.00)));
    }};

    @GetMapping(path = "/findall")
    public List<Produto> findall() {
        return this.service.FindAll();
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        Produto produtoNovo = this.service.Save(produto);
        return new ResponseEntity(produtoNovo, HttpStatus.OK);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Produto> findbyid(@PathVariable int id) {
        Produto produto = this.service.FindById(id);
        if (!Objects.nonNull(produto)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity(produto, HttpStatus.OK);
    }

    //@GetMapping(path = "/consultarPorNome")
    /*public Produto getRequest(@RequestParam(name = "nome") String nome) {
        for (Produto produto:produtos) {
            if (produto.getNome().equals(nome))
                return produto;
        }
        return null;
    }*/

    @PutMapping(path = "/update")
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        Produto produtoExiste = this.service.FindById(produto.getId());
        if (!Objects.nonNull(produtoExiste)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        Produto produtoUpdate = this.service.Save(produto);
        return new ResponseEntity(produtoUpdate, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletebyid")
    public ResponseEntity<Produto> deletebyid(@RequestParam(name = "id") long id) {
       /* for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getId() == id) {
                produtos.remove(i);
                return produto;
            }
        }*/
        Produto produtoExiste = this.service.FindById(id);
        if (!Objects.nonNull(produtoExiste)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        this.service.DeleteById(id);
        return new ResponseEntity(produtoExiste, HttpStatus.OK);
    }
}