package com.traineeprimeiro.domain.services.produto;

import com.traineeprimeiro.domain.entities.produto.Produto;
import com.traineeprimeiro.domain.services.BaseService;
import com.traineeprimeiro.infra.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends BaseService<Produto> {

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        super(repository);
    }
}
