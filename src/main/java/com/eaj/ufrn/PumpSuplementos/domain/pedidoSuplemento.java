package com.eaj.ufrn.PumpSuplementos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidoSuplemento")
public class PedidoSuplemento {
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "suplemento_id")
    private Suplemento suplemento;
    private float subtotal;

    @PrePersist
    @PreUpdate
    public void setSubtotal(Object a){
    }
}
