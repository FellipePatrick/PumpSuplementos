package com.eaj.ufrn.PumpSuplementos.dto;

import java.time.LocalDate;

import com.eaj.ufrn.PumpSuplementos.domain.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequestDTO {
    private LocalDate data;
    private Usuario cliente;
    private double total;
}
