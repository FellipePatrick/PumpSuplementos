package com.example.demo.domain;


import org.hibernate.annotations.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SQLDelete(sql = "UPDATE endereco SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
@Table(name = "endereco")
public class Endereco extends AbstractEntity{
    @NotBlank (message = "A cidade não pode estar em branco.")
    private String cidade;
    @NotBlank (message = "O estado não pode estar em branco.")
    private String estado;
    @NotBlank (message = "O pais não pode estar em branco.")
    private String pais;
    @NotBlank (message = "O logradouro não pode estar em branco.")
    private String logradouro;
    @NotBlank (message = "O bairro não pode estar em branco.")
    private String bairro;
    @NotBlank (message = "O numero não pode estar em branco.")
    private String numero;
    @NotBlank (message = "O complemento não pode estar em branco.")
    private String complemento;
}