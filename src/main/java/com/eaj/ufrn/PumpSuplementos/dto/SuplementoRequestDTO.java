package com.eaj.ufrn.PumpSuplementos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuplementoRequestDTO {
    private String nome;
    private int quantidade;
    private String imageUri;
    private float preco;
    private String descricao;
    private String categoria;
}
