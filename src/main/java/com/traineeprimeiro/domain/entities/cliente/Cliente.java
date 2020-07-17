package com.traineeprimeiro.domain.entities.cliente;

import com.traineeprimeiro.domain.entities.utils.Cep;
import com.traineeprimeiro.domain.entities.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente extends EntityBase {

    private String nome;
    private String cpfCnpj;
    private String cep;
}
