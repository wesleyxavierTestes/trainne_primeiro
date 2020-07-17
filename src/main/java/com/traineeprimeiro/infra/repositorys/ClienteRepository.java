package com.traineeprimeiro.infra.repositorys;

import com.traineeprimeiro.domain.entities.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
