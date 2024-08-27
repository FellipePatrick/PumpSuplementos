package com.example.demo.controller;
import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.example.demo.domain.Pedido;
import com.example.demo.domain.Suplemento;
import com.example.demo.dto.PedidoRequestDTO;
import com.example.demo.dto.PedidoResponseDTO;
import com.example.demo.dto.SuplementoRequestDTO;
import com.example.demo.service.PedidoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/pedidos/")
@AllArgsConstructor
// @CrossOrigin(origins = "${HOST_URL}")
@CrossOrigin(origins = "http://localhost:4200")
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
        Pedido created = service.create(pedido, convertToEntity(pedido));

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
        return ResponseEntity.ok(service.findById(id, dto));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        System.out.println("ID: " + id);
        service.deleteById(id);
    }

     @PutMapping("{id}")
    public ResponseEntity<PedidoResponseDTO> update(@RequestBody PedidoRequestDTO requestDto, @PathVariable("id") Long id) {

        try {
            Pedido p = service.findById(id);
        } catch (Exception e) {
            return this.create(requestDto);
        }
        
        Pedido PedidoUpdated = service.update(requestDto, mapper.map(requestDto, Pedido.class), id);
        return ResponseEntity.ok(convertToDto(PedidoUpdated));
    }

    private PedidoResponseDTO convertToDto(Pedido created) {
        PedidoResponseDTO PedidoResponseDTO = mapper.map(created, PedidoResponseDTO.class);
        
        for(int i=0; i<created.getSuplementos().size(); i++){
            Suplemento sup = created.getSuplementos().get(i).getSuplemento();
            PedidoResponseDTO.getSuplementos().set(i ,convertToDto(sup));
        }
        PedidoResponseDTO.addLinks(created);
        return PedidoResponseDTO;
    }
      private Pedido convertToEntity(PedidoRequestDTO pedido) {
        Pedido entitySuplemento = mapper.map(pedido, Pedido.class);
        return entitySuplemento;
    }

    private SuplementoRequestDTO convertToDto(Suplemento created) {
        SuplementoRequestDTO SuplementoRequestDTO = mapper.map(created, SuplementoRequestDTO.class);
        return SuplementoRequestDTO;
    }
}