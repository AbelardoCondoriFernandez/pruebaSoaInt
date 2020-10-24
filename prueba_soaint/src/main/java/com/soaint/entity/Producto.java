package com.soaint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Producto {
    @Id
    private int idProducto;
    private String nombre;
    private BigDecimal precio;

}
