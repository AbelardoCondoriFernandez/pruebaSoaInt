package com.soaint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detalleVenta")
@Getter@Setter
public class DetalleVenta {
    @Id
    private int idDetalleVenta;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto idProducto;

}
