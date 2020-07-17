package com.traineeprimeiro.domain.services.cliente;

import com.traineeprimeiro.domain.entities.cliente.Cliente;
import com.traineeprimeiro.domain.entities.produto.Produto;
import com.traineeprimeiro.domain.services.BaseService;
import com.traineeprimeiro.infra.repositorys.ClienteRepository;
import com.traineeprimeiro.infra.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseService<Cliente> {

    @Autowired
    public ClienteService(ClienteRepository repository) {
        super(repository);
    }
}
