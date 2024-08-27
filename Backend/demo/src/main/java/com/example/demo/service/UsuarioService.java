package com.example.demo.service;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;

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