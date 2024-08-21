package com.eaj.ufrn.PumpSuplementos.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data       
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "endereco")
public class Endereco extends AbstractEntity{
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private Long isDeleted;
}