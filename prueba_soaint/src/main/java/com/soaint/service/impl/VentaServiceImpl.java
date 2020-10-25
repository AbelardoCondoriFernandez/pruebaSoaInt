package com.soaint.service.impl;

import com.soaint.entity.Venta;
import com.soaint.repository.IVentaRepository;
import com.soaint.service.VentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {
   private IVentaRepository repository;

    public VentaServiceImpl(IVentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Venta registrar(Venta venta) {
        venta.getDetalleVentas().forEach(x->{
            x.setVenta(venta);
        });
        return repository.save(venta);
    }

    @Override
    public void modificar(Venta venta) {
        repository.save(venta);

    }

    @Override
    public void eliminar(int idVenta) {
        repository.deleteById(idVenta);

    }

    @Override
    public Venta listarId(int idVenta) {
        return repository.findById(idVenta).get();
    }

    @Override
    public List<Venta> listar() {
        return repository.findAll();
    }
}
