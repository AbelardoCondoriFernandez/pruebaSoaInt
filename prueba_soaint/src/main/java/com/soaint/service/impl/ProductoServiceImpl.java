package com.soaint.service.impl;

import com.soaint.entity.Producto;
import com.soaint.repository.IProductoRepository;
import com.soaint.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoService {
    private IProductoRepository repository;

    public ProductoServiceImpl(IProductoRepository repository) {
        this.repository = repository;
    }


    @Override
    public Producto registrar(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void modificar(Producto producto) {
        repository.save(producto);
    }

    @Override
    public void eliminar(int idProducto) {
        repository.deleteById(idProducto);
    }

    @Override
    public Producto listarId(int idProducto) {
        return repository.findById(idProducto).get();
    }

    @Override
    public List<Producto> listar() {
        return repository.findAll();
    }
}
