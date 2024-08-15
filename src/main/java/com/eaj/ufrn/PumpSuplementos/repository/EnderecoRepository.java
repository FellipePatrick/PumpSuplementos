package com.eaj.ufrn.PumpSuplementos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eaj.ufrn.PumpSuplementos.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
