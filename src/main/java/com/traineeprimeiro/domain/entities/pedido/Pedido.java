package com.traineeprimeiro.domain.entities.pedido;

import com.traineeprimeiro.domain.entities.EntityBase;
import com.traineeprimeiro.domain.entities.cliente.Cliente;
import com.traineeprimeiro.domain.entities.produto.Produto;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido  extends EntityBase {

    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany
    @JoinColumn(name = "pedido_id")
    private List<Produto> produtos;

    public void getProduto(Produto produto1) {

    }
}
