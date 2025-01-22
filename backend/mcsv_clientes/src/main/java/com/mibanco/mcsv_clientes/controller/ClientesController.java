package com.mibanco.mcsv_clientes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mibanco.mcsv_clientes.model.Clientes;
import com.mibanco.mcsv_clientes.service.ClientesService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClientesController {

    private final ClientesService clientesService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Clientes>> findAll() {
        return ResponseEntity.ok(clientesService.findAll());
    }

}
