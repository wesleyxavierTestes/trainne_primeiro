package com.traineeprimeiro.controllers;

import com.traineeprimeiro.domain.entities.loja.Loja;
import com.traineeprimeiro.domain.services.loja.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/loja")
public class LojaController {

    @Autowired
    private LojaService service;

    @GetMapping(path = "/findall")
    public List<Loja> findall() {
        return this.service.FindAll();
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Loja> save(@RequestBody Loja loja) {
        Loja lojaNovo = this.service.Save(loja);
        return new ResponseEntity(lojaNovo, HttpStatus.OK);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Loja> findbyid(@PathVariable int id) {
        Loja loja = this.service.FindById(id);
        if (!Objects.nonNull(loja)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity(loja, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Loja> update(@RequestBody Loja loja) {
        Loja lojaExiste = this.service.FindById(loja.getId());
        if (!Objects.nonNull(lojaExiste)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        Loja lojaUpdate = this.service.Save(loja);
        return new ResponseEntity(lojaUpdate, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletebyid")
    public ResponseEntity<Loja> deletebyid(@RequestParam(name = "id") long id) {
        Loja lojaExiste = this.service.FindById(id);
        if (!Objects.nonNull(lojaExiste)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        this.service.DeleteById(id);
        return new ResponseEntity(lojaExiste, HttpStatus.OK);
    }
}