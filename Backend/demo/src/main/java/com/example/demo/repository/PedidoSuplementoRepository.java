package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.PedidoSuplemento;

public interface PedidoSuplementoRepository extends JpaRepository<PedidoSuplemento, Long> {
    @Query("SELECT ps FROM PedidoSuplemento ps WHERE ps.pedido.id = :pedidoId")
    List<PedidoSuplemento> findByPedidoId(Long pedidoId);  
} 
