package com.traineeprimeiro.domain.entities.pedido;

import com.traineeprimeiro.domain.entities.EntityBase;
import com.traineeprimeiro.domain.entities.cliente.Cliente;
import com.traineeprimeiro.domain.entities.produto.Produto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(AccessLevel.PUBLIC) @Setter protected long id;

    private BigDecimal valorTotal;
    private Cliente cliente;
    private List<Produto> produtos;

    public void getProduto(Produto produto1) {

    }

/*
    public boolean validar() {
        boolean produtosValido = Objects.nonNull(this.produtos) && this.produtos.size() > 0;
        boolean clienteValido = Objects.nonNull(this.cliente) && this.cliente.getId() > 0;
        boolean valorTotalValido = Objects.nonNull(this.valorTotal) && this.valorTotal.doubleValue() >= 0.0D;

        return  false;
    }
 */
}
