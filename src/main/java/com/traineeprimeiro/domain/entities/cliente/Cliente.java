package com.traineeprimeiro.domain.entities.cliente;

import com.traineeprimeiro.domain.entities.loja.Loja;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_Id")
    private List<Telefone> telefones;

    @ManyToOne
    @JoinColumn(name = "loja_id")
    private Loja loja;

}
