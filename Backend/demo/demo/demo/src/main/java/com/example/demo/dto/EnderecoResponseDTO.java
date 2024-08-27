package com.example.demo.dto;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.controller.EnderecoController;
import com.example.demo.domain.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponseDTO extends RepresentationModel<EnderecoResponseDTO>{
    private String logradouro;
    private String bairro;
    private String cidade;
    private String pais;
    private String estado;
    private String numero;
    private String complemento;

    public void addLinks(Endereco end){
        this.add(linkTo(EnderecoController.class).slash(end.getId()).withSelfRel());
    }
}