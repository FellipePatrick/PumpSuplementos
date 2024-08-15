package com.eaj.ufrn.PumpSuplementos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eaj.ufrn.PumpSuplementos.domain.Pedido;
import com.eaj.ufrn.PumpSuplementos.dto.PedidoResponseDTO;
import com.eaj.ufrn.PumpSuplementos.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidoController {
    
    private final PedidoService service;

    // @GetMapping("{id}")
    // public ResponseEntity<PedidoResponseDTO> listById(@PathVariable("id") Long id) {
    //     Pedido pedido = this.service.findById(id);
    //     PedidoResponseDTO pedidoResponseDTO = mapper.map(pedido, PedidoResponseDTO.class);
    // }
    
}
