package com.traineeprimeiro.controllers;

import com.traineeprimeiro.domain.entities.loja.Loja;
import com.traineeprimeiro.domain.entities.cliente.Cliente;
import com.traineeprimeiro.domain.services.cliente.ClienteService;
import com.traineeprimeiro.domain.services.loja.LojaService;
import com.traineeprimeiro.enuns.EnumTipoPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private LojaService serviceLoja;

    @GetMapping(path = "/findall")
    public List<Cliente> findall() {
        return this.service.FindAll();
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> save(@RequestBody Cliente cliente) {

        if (Objects.nonNull(cliente) && Objects.nonNull(cliente.getLoja())) {
            boolean exists = this.serviceLoja.ExistsById(cliente.getLoja().getId());
            if (exists) return new ResponseEntity("Loja Inexistente", HttpStatus.NO_CONTENT);
        }

        Cliente clienteNovo = this.service.Save(cliente);
        return new ResponseEntity(clienteNovo, HttpStatus.OK);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Cliente> findbyid(@PathVariable int id) {
        Cliente cliente = this.service.FindById(id);
        if (!Objects.nonNull(cliente)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        Loja loja = cliente.getLoja();
        if (Objects.nonNull(loja)) {
            loja = this.serviceLoja.FindById(loja.getId());
            if (!Objects.nonNull(loja)) {
                return new ResponseEntity("Loja Inexistente", HttpStatus.NO_CONTENT);
            }
        }

        Cliente clienteUpdate = this.service.Save(cliente);
        if (!Objects.nonNull(cliente)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity(clienteUpdate, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletebyid")
    public ResponseEntity<Cliente> deletebyid(@RequestParam(name = "id") long id) {
        Cliente clienteExiste = this.service.FindById(id);
        if (!Objects.nonNull(clienteExiste)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        this.service.DeleteById(id);
        return new ResponseEntity(clienteExiste, HttpStatus.OK);
    }
}