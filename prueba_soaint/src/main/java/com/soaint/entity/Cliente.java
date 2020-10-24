package com.soaint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    private int idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;

}
