package com.eaj.ufrn.PumpSuplementos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eaj.ufrn.PumpSuplementos.domain.Usuario;
import com.eaj.ufrn.PumpSuplementos.repository.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<Usuario, Long, UsuarioRepository>{
    public UsuarioService(UsuarioRepository repository){
        super(repository);
    }

    @Override
    public List<Usuario> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}