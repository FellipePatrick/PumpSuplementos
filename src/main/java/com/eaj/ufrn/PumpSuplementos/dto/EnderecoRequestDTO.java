package com.eaj.ufrn.PumpSuplementos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequestDTO{
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
}
