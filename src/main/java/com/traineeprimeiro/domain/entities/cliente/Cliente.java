package com.traineeprimeiro.domain.entities.cliente;

import com.traineeprimeiro.domain.entities.EntityBase;
import com.traineeprimeiro.domain.entities.loja.Loja;
import com.traineeprimeiro.domain.entities.utils.Telefone;
import com.traineeprimeiro.enuns.EnumTipoPessoa;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente extends EntityBase {

    private String nome;
    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    private EnumTipoPessoa TipoPessoa;
    private String cep;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_Id")
    private List<Telefone> telefones;

    @ManyToOne
    @JoinColumn(name = "loja_id")
    private Loja loja;

}
