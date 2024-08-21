package com.eaj.ufrn.PumpSuplementos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    private String nome;
    private String email;
    private Boolean isAdmin;
    private String password;
    private  EnderecoRequestDTO endereco;
    
}
