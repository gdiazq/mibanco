package com.mibanco.mcsv_cuentas.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    

}
