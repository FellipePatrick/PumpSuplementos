package com.eaj.ufrn.PumpSuplementos.controller;


import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eaj.ufrn.PumpSuplementos.domain.Pedido;
import com.eaj.ufrn.PumpSuplementos.dto.PedidoRequestDTO;
import com.eaj.ufrn.PumpSuplementos.dto.PedidoResponseDTO;
import com.eaj.ufrn.PumpSuplementos.service.PedidoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/pedidos/")
@AllArgsConstructor
public class PedidoController {
     private final PedidoService service;
    private final ModelMapper mapper;

    @GetMapping
    public Page<PedidoResponseDTO> listAll(Pageable pageable) {
        Page<Pedido> pedidoPage = service.listAll(pageable);
        return pedidoPage.map(this::convertToDto);
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> create(@RequestBody PedidoRequestDTO pedido) {
        Pedido created = service.create(convertToEntity(pedido));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoResponseDTO> listById(@PathVariable("id") Long id) {
        Pedido p = service.findById(id);
        PedidoResponseDTO dto = mapper.map(p, PedidoResponseDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

     @PutMapping("{id}")
    public ResponseEntity<PedidoResponseDTO> update(@RequestBody PedidoRequestDTO requestDto, @PathVariable("id") Long id) {

        try {
            Pedido p = service.findById(id);
        } catch (Exception e) {
            return this.create(requestDto);
        }
        Pedido PedidoUpdated = service.update(mapper.map(requestDto, Pedido.class), id);
        return ResponseEntity.ok(convertToDto(PedidoUpdated));
    }



    private PedidoResponseDTO convertToDto(Pedido created) {
        PedidoResponseDTO PedidoResponseDTO = mapper.map(created, PedidoResponseDTO.class);
        PedidoResponseDTO.addLinks(created);
        return PedidoResponseDTO;
    }
      private Pedido convertToEntity(PedidoRequestDTO pedido) {
        Pedido entitySuplemento = mapper.map(pedido, Pedido.class);
        return entitySuplemento;
    }

}