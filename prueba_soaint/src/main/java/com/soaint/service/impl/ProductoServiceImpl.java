package com.soaint.service.impl;

import com.soaint.entity.Cliente;
import com.soaint.repository.IClienteRepository;
import com.soaint.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ClienteService {
    private IClienteRepository repository;

    public ProductoServiceImpl(IClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente registrar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void modificar(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void eliminar(int idCliente) {
         repository.deleteById(idCliente);
    }

    @Override
    public Optional<Cliente> listarId(int idCliente) {
        return repository.findById(idCliente);
    }

    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }
}
