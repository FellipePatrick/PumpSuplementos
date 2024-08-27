package com.example.demo.controller;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Suplemento;
import com.example.demo.dto.SuplementoRequestDTO;
import com.example.demo.dto.SuplementoResponseDTO;
import com.example.demo.service.SuplementoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/suplementos/")
@AllArgsConstructor
public class SuplementoController {
    private final SuplementoService service;
    private final ModelMapper mapper;

    @GetMapping
    public Page<SuplementoResponseDTO> listAll(Pageable pageable) {
        Page<Suplemento> suplementosPage = service.listAll(pageable);
        return suplementosPage.map(this::convertToDto);
    }

    @PostMapping
    public ResponseEntity<SuplementoResponseDTO> create(@RequestBody SuplementoRequestDTO suplemento) {
        Suplemento created = service.create(convertToEntity(suplemento));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping("{id}")
    public ResponseEntity<SuplementoResponseDTO> listById(@PathVariable("id") Long id) {
        Suplemento p = service.findById(id);
        SuplementoResponseDTO dto = mapper.map(p, SuplementoResponseDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

     @PutMapping("{id}")
    public ResponseEntity<SuplementoResponseDTO> update(@RequestBody SuplementoRequestDTO requestDto, @PathVariable("id") Long id) {

        try {
            Suplemento p = service.findById(id);
        } catch (Exception e) {
            return this.create(requestDto);
        }
        Suplemento SuplementoUpdated = service.update(mapper.map(requestDto, Suplemento.class), id);
        return ResponseEntity.ok(convertToDto(SuplementoUpdated));
    }


    private SuplementoResponseDTO convertToDto(Suplemento created) {
        SuplementoResponseDTO SuplementoResponseDTO = mapper.map(created, SuplementoResponseDTO.class);
        SuplementoResponseDTO.addLinks(created);
        return SuplementoResponseDTO;
    }
      private Suplemento convertToEntity(SuplementoRequestDTO suplemento) {
        Suplemento entitySuplemento = mapper.map(suplemento, Suplemento.class);
        return entitySuplemento;
    }
}
