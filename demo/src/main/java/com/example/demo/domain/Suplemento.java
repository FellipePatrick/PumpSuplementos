package com.example.demo.domain;

import org.hibernate.annotations.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SQLDelete(sql = "UPDATE suplemento SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
@Table(name = "suplemento")
public class Suplemento extends AbstractEntity{
    @NotBlank (message = "O nome não pode estar em branco.")
    private String nome;
    @Min(value = 0, message = "Ao menos um item precisa ser cadastrado")
    private int quantidade;
   // @NotBlank (message = "A imagem não pode estar em branco.")
    private String imageUri;
    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(value = "0.1", inclusive = true, message = "O preço deve ser pelo menos 0.1.")
    private float preco;
    @NotBlank (message = "A descrição não pode estar em branco.")
    private String descricao;
    @NotBlank (message = "A categoria não pode estar em branco.")
    private String categoria;
}