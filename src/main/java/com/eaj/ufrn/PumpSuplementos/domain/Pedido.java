package com.eaj.ufrn.PumpSuplementos.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedido")
public class Pedido extends AbstractEntity{
    private LocalDate data;
    private Long isDeleted;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    private List<Suplemento> suplementos;
}