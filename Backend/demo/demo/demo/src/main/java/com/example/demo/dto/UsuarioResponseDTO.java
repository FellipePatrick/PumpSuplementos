package com.example.demo.dto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.hateoas.RepresentationModel;

import com.example.demo.controller.UsuarioController;
import com.example.demo.domain.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioResponseDTO extends RepresentationModel<UsuarioResponseDTO>{
    private String nome;
    private String email;
    private String password;
    private Boolean isAdmin;
    private EnderecoRequestDTO endereco;

    public void addLinks(Usuario usuario){
        this.add(linkTo(UsuarioController.class).slash(usuario.getEmail()).withSelfRel());
    }
}
