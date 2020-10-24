package com.soaint.service;

import com.soaint.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    Cliente registrar(Cliente cliente);

    void modificar(Cliente cliente);

    void eliminar(int idCliente);

    Optional<Cliente> listarId(int idCliente);

    List<Cliente> listar();
}
