package com.eaj.ufrn.PumpSuplementos.service;

import org.springframework.stereotype.Service;

import com.eaj.ufrn.PumpSuplementos.domain.Endereco;
import com.eaj.ufrn.PumpSuplementos.repository.EnderecoRepository;

@Service
public class EnderecoService extends GenericService<Endereco, Long, EnderecoRepository>{
    public EnderecoService(EnderecoRepository repository){
        super(repository);
    }
    
}
