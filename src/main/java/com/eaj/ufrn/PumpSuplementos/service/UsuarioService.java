package com.eaj.ufrn.PumpSuplementos.service;

import org.springframework.stereotype.Service;

import com.eaj.ufrn.PumpSuplementos.domain.Usuario;
import com.eaj.ufrn.PumpSuplementos.repository.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<Usuario, String, UsuarioRepository>{
    public UsuarioService(UsuarioRepository repository){
        super(repository);
    }
    
}