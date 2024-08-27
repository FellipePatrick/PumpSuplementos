package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequestDTO{
    private String logradouro;
    private String bairro;
    private String cidade;
    private String pais;
    private String estado;
    private String numero;
    private String complemento;
}
