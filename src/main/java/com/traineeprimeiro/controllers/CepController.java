package com.traineeprimeiro.controllers;

import com.traineeprimeiro.domain.entities.utils.Cep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traineeprimeiro.utils.HttpBase;
import com.traineeprimeiro.utils.Validacao;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    @GetMapping(path = "consultar/{cep}")
    public ResponseEntity<Cep> getCep(@PathVariable(name = "cep") String cep) {
        if (!Validacao.validarCep(cep)) return new ResponseEntity(null, HttpStatus.BAD_REQUEST);

        String url = "https://viacep.com.br/ws/{parametro}/json/";

        ResponseEntity<Cep> cepConsultado = HttpBase.getParameterResponseEntity(url, cep, Cep.class);

        return cepConsultado;
    }

    @GetMapping(path = "consultar/piped/{cep}")
    public ResponseEntity<String> getCepPiped(@PathVariable(name = "cep") String cep) {
        if (!Validacao.validarCep(cep)) return new ResponseEntity(null, HttpStatus.BAD_REQUEST);

        String url = "https://viacep.com.br/ws/{parametro}/piped/";

        ResponseEntity<String> cepConsultado = HttpBase.getParameterResponseEntity(url, cep, String.class);

        return cepConsultado;
    }
}
