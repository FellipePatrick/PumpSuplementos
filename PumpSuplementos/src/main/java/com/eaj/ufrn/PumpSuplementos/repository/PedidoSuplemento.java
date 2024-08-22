package com.eaj.ufrn.PumpSuplementos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eaj.ufrn.PumpSuplementos.domain.Pedido;

public interface PedidoSuplemento extends JpaRepository<Pedido, Long> {
    
}
