package com.example.demo.domain;

import org.hibernate.annotations.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SQLDelete(sql = "UPDATE pessoa SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
@Table(name = "usuario")
public class Usuario extends AbstractEntity {
    @NotBlank (message = "O nome não pode estar em branco.")
    private String nome;
    @NotBlank (message = "O email não pode estar em branco.")
    private String email;
    @Size(min = 8, max = 100, message = "A senha deve ter no mínimo 8 caracteres.")
    private String password;
    private Boolean isAdmin;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) 
    private Endereco endereco;
    public boolean isIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
