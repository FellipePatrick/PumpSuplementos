package com.eaj.ufrn.PumpSuplementos.repository;

import com.eaj.ufrn.PumpSuplementos.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
