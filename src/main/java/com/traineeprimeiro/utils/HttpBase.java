package com.traineeprimeiro.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public final class HttpBase {
    private HttpBase() { }

    public static <T> ResponseEntity<T> getParameterResponseEntity(String url, String parametro, Class<T> tipo) {
        RestTemplate http = new RestTemplate();
        ResponseEntity<T> consultado = http.getForEntity(url, tipo, parametro);

        if (consultado.getStatusCode() != HttpStatus.OK)
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);

        if (consultado.getBody() == null) return new ResponseEntity(null, HttpStatus.NO_CONTENT);

        return new ResponseEntity(consultado.getBody(), HttpStatus.OK);

    }
}
