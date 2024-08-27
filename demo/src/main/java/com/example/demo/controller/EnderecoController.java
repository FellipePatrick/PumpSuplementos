package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Endereco;
import com.example.demo.service.EnderecoService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

// @CrossOrigin(origins = "${HOST_URL}")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/enderecos/")
@AllArgsConstructor
public class EnderecoController {

    EnderecoService service;

    @GetMapping
    public Page<Endereco> listaEnderecos(Pageable pageable){
        return service.listAll(pageable);
    }
}
