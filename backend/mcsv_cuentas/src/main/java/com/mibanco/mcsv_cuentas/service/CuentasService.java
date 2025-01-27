package com.mibanco.mcsv_cuentas.service;

import java.util.List;

import com.mibanco.mcsv_cuentas.model.Cuentas;

public interface CuentasService {

    Iterable<Cuentas> findAll();

    List<Cuentas> findByRut(String rut);

}
