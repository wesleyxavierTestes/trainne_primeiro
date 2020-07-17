package com.traineeprimeiro.controllers;

import com.traineeprimeiro.domain.entities.pedido.Pedido;
import com.traineeprimeiro.domain.services.pedido.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping(path = "/findall")
    public List<Pedido> findall() {
        return this.service.FindAll();
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        Pedido pedidoNovo = this.service.Save(pedido);
        return new ResponseEntity(pedidoNovo, HttpStatus.OK);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Pedido> findbyid(@PathVariable int id) {
        Pedido pedido = this.service.FindById(id);
        if (!Objects.nonNull(pedido)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity(pedido, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido) {
        Pedido pedidoExiste = this.service.FindById(pedido.getId());
        if (!Objects.nonNull(pedidoExiste)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);

        Pedido pedidoUpdate = this.service.Save(pedido);
        return new ResponseEntity(pedidoUpdate, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletebyid")
    public ResponseEntity<Pedido> deletebyid(@RequestParam(name = "id") long id) {
        Pedido pedidoExiste = this.service.FindById(id);
        if (!Objects.nonNull(pedidoExiste)) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        this.service.DeleteById(id);
        return new ResponseEntity(pedidoExiste, HttpStatus.OK);
    }
}