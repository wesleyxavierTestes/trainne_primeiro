package com.traineeprimeiro.domain.entities;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private long id;
    private String nome;
    private BigDecimal valor;
}
