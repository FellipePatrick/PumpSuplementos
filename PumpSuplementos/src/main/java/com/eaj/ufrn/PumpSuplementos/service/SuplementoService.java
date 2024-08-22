package com.eaj.ufrn.PumpSuplementos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eaj.ufrn.PumpSuplementos.domain.Suplemento;
import com.eaj.ufrn.PumpSuplementos.repository.SuplementoRepository;

@Service
public class SuplementoService extends GenericService<Suplemento, Long, SuplementoRepository>{
    public SuplementoService(SuplementoRepository repository){
        super(repository);
    }

    @Override
    public List<Suplemento> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
