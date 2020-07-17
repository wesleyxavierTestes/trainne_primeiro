package com.traineeprimeiro.domain.services.loja;

import com.traineeprimeiro.domain.entities.cliente.Cliente;
import com.traineeprimeiro.domain.entities.loja.Loja;
import com.traineeprimeiro.domain.services.BaseService;
import com.traineeprimeiro.infra.repositorys.ClienteRepository;
import com.traineeprimeiro.infra.repositorys.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService extends BaseService<Loja> {

    @Autowired
    public LojaService(LojaRepository repository) {
        super(repository);
    }
}
