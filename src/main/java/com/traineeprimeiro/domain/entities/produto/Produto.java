package com.traineeprimeiro.domain.entities.produto;

import java.math.BigDecimal;

import com.traineeprimeiro.domain.entities.EntityBase;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto extends EntityBase {
    private String nome;
    private BigDecimal valor;
}
