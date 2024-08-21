package com.eaj.ufrn.PumpSuplementos.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eaj.ufrn.PumpSuplementos.domain.Endereco;
import com.eaj.ufrn.PumpSuplementos.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/enderecos")
@AllArgsConstructor
public class EnderecoController {

    EnderecoService service;

    @GetMapping
    public Page<Endereco> listaEnderecos(Pageable pageable){
        return service.listAll(pageable);
    }
}