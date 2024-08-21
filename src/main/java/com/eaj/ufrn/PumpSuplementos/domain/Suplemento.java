package com.eaj.ufrn.PumpSuplementos.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "suplemento")
public class Suplemento extends AbstractEntity{
    private String nome;
    private int quantidade;
    private String imageUri;
    private float preco;
    private String descricao;
    private String categoria;
    private Long isDeleted;
}