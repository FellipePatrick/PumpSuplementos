package com.eaj.ufrn.PumpSuplementos.service;

import org.springframework.stereotype.Service;

import com.eaj.ufrn.PumpSuplementos.domain.Suplemento;
import com.eaj.ufrn.PumpSuplementos.repository.SuplementoRepository;

@Service
public class SuplementoService extends GenericService<Suplemento, Long, SuplementoRepository>{
    public SuplementoService(SuplementoRepository repository){
        super(repository);
    }
}
