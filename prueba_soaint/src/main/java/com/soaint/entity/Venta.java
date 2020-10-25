package com.soaint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "venta")
public class Venta {
    @Id
    private int idVenta;
    @ManyToOne
    @JoinColumn(name="id_cliente",nullable = false)
    private Cliente idCliente;
    private LocalDateTime fecha;
    @OneToMany(mappedBy = "venta", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DetalleVenta>detalleVentas;

}
