package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
@SQLDelete(sql = "UPDATE usuario SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
public class Usuario extends AbstractEntity implements UserDetails {
    
    @NotBlank (message = "O nome não pode estar em branco.")
    private String nome;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) 
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    
    private Boolean isAdmin;
    
    @NotBlank (message = "O email não pode estar em branco.")
    @Column(unique = true)
    private String email;

    @Size(min = 8, max = 100, message = "A senha deve ter no mínimo 8 caracteres.")
    @Column
    private String password;

    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.isAdmin){
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else{
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}