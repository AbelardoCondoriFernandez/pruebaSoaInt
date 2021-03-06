package com.soaint.service.impl;

import com.soaint.entity.Cliente;
import com.soaint.repository.IClienteRepository;
import com.soaint.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private IClienteRepository repository;

    public ClienteServiceImpl(IClienteRepository repository) {
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
    public Cliente listarId(int idCliente) {
        return repository.findById(idCliente).get();
    }

    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }
}
