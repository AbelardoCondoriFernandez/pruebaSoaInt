package com.soaint.service;

import com.soaint.entity.Producto;

import java.util.List;

public interface ProductoService {

    Producto registrar(Producto producto);

    void modificar(Producto producto);

    void eliminar(int idProducto);
    Producto listarId(int idProducto);
    List<Producto> listar();
}
