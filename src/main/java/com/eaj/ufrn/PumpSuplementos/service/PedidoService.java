package com.eaj.ufrn.PumpSuplementos.service;

import org.springframework.stereotype.Service;

import com.eaj.ufrn.PumpSuplementos.domain.Pedido;
import com.eaj.ufrn.PumpSuplementos.repository.PedidoRepository;

@Service
public class PedidoService extends GenericService<Pedido, Long, PedidoRepository>{
    public PedidoService(PedidoRepository repository){
        super(repository);
    }
}
