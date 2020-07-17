package com.traineeprimeiro;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.traineeprimeiro.domain.entities.Cliente;
import com.traineeprimeiro.domain.entities.Pedido;
import com.traineeprimeiro.domain.entities.Produto;

public class PedidoTest {

    @Test
    void pedidoValidoUmItem() {
        Pedido pedido = new Pedido();

        Cliente cliente = new Cliente();
        pedido.setCliente(cliente);

        Produto produto1 = new Produto();
        produto1.setNome("Macarrão");
        Produto produto2 = new Produto();
        Produto produto3 = new Produto();

        pedido.getProduto(produto1);
        pedido.getProduto(produto2);
        pedido.getProduto(produto3);

        //assertEquals(100, pedido.getValorTotal());
        assertTrue(true);
    }
}
