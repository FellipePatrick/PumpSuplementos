package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Endereco;
import com.example.demo.repository.EnderecoRepository;

@Service
public class EnderecoService extends GenericService<Endereco, Long, EnderecoRepository>{
    public EnderecoService(EnderecoRepository repository){
        super(repository);
    }

    @Override
    public List<Endereco> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}