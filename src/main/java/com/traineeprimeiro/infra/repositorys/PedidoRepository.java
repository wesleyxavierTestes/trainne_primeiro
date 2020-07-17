package com.traineeprimeiro.infra.repositorys;

import com.traineeprimeiro.domain.entities.cliente.Cliente;
import com.traineeprimeiro.domain.entities.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
