package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.hateoas.RepresentationModel;

import com.example.demo.controller.PedidoController;
import com.example.demo.controller.SuplementoController;
import com.example.demo.controller.UsuarioController;
import com.example.demo.domain.Pedido;
import com.example.demo.domain.PedidoSuplemento;
import com.example.demo.domain.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDTO extends RepresentationModel<PedidoResponseDTO>{
    private UsuarioRequestDTO cliente;
    private double total;
    private LocalDateTime createdAt;
    private List<SuplementoRequestDTO> suplementos;

    public void addLinks(Pedido ped){
        this.add(linkTo(PedidoController.class).slash(ped.getId()).withSelfRel());
        this.add(linkTo(UsuarioController.class).slash(ped.getCliente().getId()).withRel("cliente"));
        List<PedidoSuplemento> sups = ped.getSuplementos();
        for(PedidoSuplemento sup : sups){
            this.add(linkTo(SuplementoController.class).slash(sup.getSuplemento().getId()).withRel("suplementos"));
        }
    }
}
