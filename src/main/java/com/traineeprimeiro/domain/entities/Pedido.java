package com.traineeprimeiro.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido extends  EntityBase {

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
