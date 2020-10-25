package com.soaint.controller;

import com.soaint.entity.Venta;
import com.soaint.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/soaint/venta")
public class VentaController {

    private final VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Venta>> listar() {
        List<Venta> venta = new ArrayList<>();
        try {
            venta = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Venta>>(venta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Venta>>(venta, HttpStatus.OK);

    }
    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venta> listarId(@PathVariable("id") Integer id) {
        Venta venta = new Venta();
        try {
            venta = service.listarId(id);
        } catch (Exception e) {
            return new ResponseEntity<Venta>(venta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Venta>(venta, HttpStatus.OK);
    }
    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venta> registrar(@RequestBody Venta venta) {
        service.registrar(venta);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(venta);

    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Venta venta) {

        int resultado = 0;
        try {
            service.modificar(venta);
            resultado = 1;
        } catch (Exception e) {
            resultado = 0;
        }

        return new ResponseEntity<Integer>(resultado, HttpStatus.OK);

    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {

        int resultado = 0;
        try {
            service.eliminar(id);
            resultado = 1;
        } catch (Exception e) {
            resultado = 0;
        }

        return new ResponseEntity<Integer>(resultado, HttpStatus.OK);

    }
}
