package com.soaint.service;

import com.soaint.entity.Venta;

import java.util.List;

public interface VentaService {

    Venta registrar(Venta venta);

    void modificar(Venta venta);

    void eliminar(int idVenta);

    Venta listarId(int idVenta);

    List<Venta> listar();
}
