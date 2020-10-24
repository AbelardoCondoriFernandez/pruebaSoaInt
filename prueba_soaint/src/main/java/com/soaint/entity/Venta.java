package com.soaint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    private Date fecha;


}
