package com.eaj.ufrn.PumpSuplementos.dto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;
import com.eaj.ufrn.PumpSuplementos.controller.PedidoController;
import com.eaj.ufrn.PumpSuplementos.domain.Pedido;
import com.eaj.ufrn.PumpSuplementos.domain.Usuario;

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