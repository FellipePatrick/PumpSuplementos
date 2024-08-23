package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Pedido;
import com.example.demo.repository.PedidoRepository;



@Service
public class PedidoService extends GenericService<Pedido, Long, PedidoRepository>{
    public PedidoService(PedidoRepository repository){
        super(repository);
    }

    @Override
    public List<Pedido> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
