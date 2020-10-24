package com.soaint.controller;

import com.soaint.entity.Cliente;
import com.soaint.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/soaint/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> cliente = new ArrayList<>();
        try {
            cliente = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);

    }

    // Registro por el tipo de objeto Estandar
    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente) {
        service.registrar(cliente);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cliente);

    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> actualizar(@RequestBody Cliente cliente) {

        int resultado = 0;
        try {
            service.modificar(cliente);
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
