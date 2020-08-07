package com.traineeprimeiro.infra.repositorys;

import com.traineeprimeiro.domain.entities.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
