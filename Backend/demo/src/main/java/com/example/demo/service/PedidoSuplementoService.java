package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.PedidoSuplemento;
import com.example.demo.repository.PedidoSuplementoRepository;

@Service
public class PedidoSuplementoService extends GenericService<PedidoSuplemento, Long, PedidoSuplementoRepository> {
    private final PedidoSuplementoRepository pedidoSuplementoRepository;

    public PedidoSuplementoService(PedidoSuplementoRepository repository, PedidoSuplementoRepository pedidoSuplementoRepository) {
        super(repository);
        this.pedidoSuplementoRepository = pedidoSuplementoRepository;
    }

    @Override
    public List<PedidoSuplemento> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public List<PedidoSuplemento> findByPedidoId(Long pedidoId) {
        return pedidoSuplementoRepository.findByPedidoId(pedidoId);
    }
   
}
