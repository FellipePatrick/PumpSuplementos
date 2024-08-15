package com.eaj.ufrn.PumpSuplementos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eaj.ufrn.PumpSuplementos.domain.Endereco;
import com.eaj.ufrn.PumpSuplementos.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/enderecos")
@AllArgsConstructor
public class EnderecoController {

    private EnderecoService service;

    @GetMapping    
    public Endereco listById(Long id){
        return this.service.findById(id);
    }
    
}
