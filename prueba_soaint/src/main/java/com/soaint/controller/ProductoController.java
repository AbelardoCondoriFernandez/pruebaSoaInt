package com.soaint.controller;

import com.soaint.entity.Producto;
import com.soaint.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/soaint/producto")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> producto = new ArrayList<>();
        try {
            producto = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Producto>>(producto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Producto>>(producto, HttpStatus.OK);

    }
    @GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> listarId(@PathVariable("id") Integer id) {
        Producto producto = new Producto();
        try {
            producto = service.listarId(id);
        } catch (Exception e) {
            return new ResponseEntity<Producto>(producto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }
    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> registrar(@RequestBody Producto producto) {
        service.registrar(producto);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(producto);

    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Producto producto) {

        int resultado = 0;
        try {
            service.modificar(producto);
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
