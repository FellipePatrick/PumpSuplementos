package com.example.demo.dto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.hateoas.RepresentationModel;
import com.example.demo.controller.SuplementoController;
import com.example.demo.domain.Suplemento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuplementoResponseDTO extends RepresentationModel<SuplementoResponseDTO>{
    private String nome;
    private int quantidade;
    private String imageUri;
    private float preco;
    private String descricao;
    private String categoria;

    public void addLinks(Suplemento sup){
        this.add(linkTo(SuplementoController.class).slash(sup.getId()).withSelfRel());
    }
}