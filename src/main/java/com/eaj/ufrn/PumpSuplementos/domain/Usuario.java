package com.eaj.ufrn.PumpSuplementos.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario extends AbstractEntity{
    private String nome;
    private String email;
    private String password;
    @OneToOne
    private Endereco endereco;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, orphanRemoval = true,
    cascade = CascadeType.ALL)
    private List<Pedido> pedidos;
}   
