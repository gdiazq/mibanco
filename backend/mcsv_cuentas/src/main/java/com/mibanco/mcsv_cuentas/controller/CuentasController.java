package com.mibanco.mcsv_cuentas.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mibanco.mcsv_cuentas.model.Cuentas;
import com.mibanco.mcsv_cuentas.service.CuentasService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/cuentas")
@AllArgsConstructor
public class CuentasController {

    private final CuentasService cuentasService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Cuentas>> findAll() {
        return ResponseEntity.ok(cuentasService.findAll());
    }

    @GetMapping("/{rut}")
    public ResponseEntity<List<Cuentas>> findByRut(@PathVariable String rut) {
        List<Cuentas> cuenta = cuentasService.findByRut(rut);

        if (cuenta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } 
        return ResponseEntity.ok(cuenta);
    }

    @PostMapping
    public ResponseEntity<Cuentas> save(@RequestBody Cuentas cuentas) {
        Cuentas nuevaCuenta = cuentasService.save(cuentas);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCuenta);
    }

}
