package com.example.demo.domain;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.*;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.CascadeType;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SQLDelete(sql = "UPDATE pedido SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
@Table(name = "pedido")
public class Pedido extends AbstractEntity{
    @NotNull(message = "O total não pode ser nulo.")
    @DecimalMin(value = "0.1", inclusive = true, message = "O total deve ser pelo menos 0.1.")
    private double total;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

}