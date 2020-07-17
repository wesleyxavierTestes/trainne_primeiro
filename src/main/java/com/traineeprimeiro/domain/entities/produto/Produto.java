package com.traineeprimeiro.domain.entities.produto;

import java.math.BigDecimal;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

import com.traineeprimeiro.domain.entities.EntityBase;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.PUBLIC) @Setter protected long id;
    private String nome;
    private BigDecimal valor;
}
