package com.example.demo.dto;



import com.example.demo.domain.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequestDTO {
    private Usuario cliente;
    private double total;
    private String token;
}
