package com.traineeprimeiro.domain.services.pedido;

import com.traineeprimeiro.domain.entities.cliente.Cliente;
import com.traineeprimeiro.domain.entities.pedido.Pedido;
import com.traineeprimeiro.domain.services.BaseService;
import com.traineeprimeiro.infra.repositorys.ClienteRepository;
import com.traineeprimeiro.infra.repositorys.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends BaseService<Pedido> {

    @Autowired
    public PedidoService(PedidoRepository repository) {
        super(repository);
    }
}
