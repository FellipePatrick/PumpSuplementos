package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Suplemento;
import com.example.demo.repository.SuplementoRepository;


@Service
public class SuplementoService extends GenericService<Suplemento, Long, SuplementoRepository>{

    private SuplementoRepository repository;
    public SuplementoService(SuplementoRepository repository){
        super(repository);
        this.repository = repository;
    }


    public List<Suplemento> findAllWhereIsDeletedIsNotNull() {
        return this.repository.findAllWhereIsDeletedIsNotNull();
    }

    @Override
    public Suplemento update(Suplemento entity, Long id) {
        entity.setId(id);
        return super.update(entity, id);
    }

    @Override
    public List<Suplemento> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
