package com.eaj.ufrn.PumpSuplementos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eaj.ufrn.PumpSuplementos.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
}
