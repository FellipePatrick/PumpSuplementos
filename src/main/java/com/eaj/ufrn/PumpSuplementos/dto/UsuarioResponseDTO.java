package com.eaj.ufrn.PumpSuplementos.dto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.hateoas.RepresentationModel;
import com.eaj.ufrn.PumpSuplementos.controller.UsuarioController;
import com.eaj.ufrn.PumpSuplementos.domain.Usuario;
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

    public void addLinks(Usuario usuario){
        this.add(linkTo(UsuarioController.class).slash(usuario.getEmail()).withSelfRel());
    }
}
