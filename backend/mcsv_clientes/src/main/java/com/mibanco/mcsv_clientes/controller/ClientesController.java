package com.mibanco.mcsv_clientes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mibanco.mcsv_clientes.dto.ClientesDto;
import com.mibanco.mcsv_clientes.model.Clientes;
import com.mibanco.mcsv_clientes.service.ClientesService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClientesController {

    private final ClientesService clientesService;

    //Endpoint Clientes

    @GetMapping("/all")
    public ResponseEntity<Iterable<Clientes>> findAll() {
        return ResponseEntity.ok(clientesService.findAll());
    }

    @GetMapping("/{rut}")
    public ResponseEntity<List<Clientes>> findByRut(@PathVariable String rut) {
        List<Clientes> cliente = clientesService.findByRut(rut);

        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Clientes> save(@RequestBody Clientes clientes) {
        Clientes nuevoCliente = clientesService.save(clientes);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }
    
    //Endpoint Clientes con cuentas

    @GetMapping("cuenta/all-with-cuentas")
    public ResponseEntity<List<ClientesDto>> findAllClientesWithCuentas() {
        return ResponseEntity.ok(clientesService.findAllClientesWithCuentas());
    }

    @GetMapping("cuenta/{rut}")
    public ResponseEntity<List<ClientesDto>> findAllClientesWithCuentasByRut(@PathVariable String rut) {
        return ResponseEntity.ok(clientesService.findAllClientesWithCuentasByRut(rut));
    }

    
    
    
}
