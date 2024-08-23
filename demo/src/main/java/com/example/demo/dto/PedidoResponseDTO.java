package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.hateoas.RepresentationModel;

import com.example.demo.controller.PedidoController;
import com.example.demo.domain.Pedido;
import com.example.demo.domain.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDTO extends RepresentationModel<PedidoResponseDTO>{
    private Usuario cliente;
    private double total;
    private LocalDateTime createdAt;
    public void addLinks(Pedido ped){
        this.add(linkTo(PedidoController.class).slash(ped.getId()).withSelfRel());
    }
}
