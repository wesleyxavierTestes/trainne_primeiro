package com.traineeprimeiro.domain.entities.cliente;

import com.traineeprimeiro.domain.entities.utils.Telefone;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String cpfCnpj;
    private String cep;

    @OneToMany()
    @JoinColumn(name = "cliente_Id")
    private List<Telefone> telefone;

}
