package com.mibanco.mcsv_cuentas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mibanco.mcsv_cuentas.model.Cuentas;

public interface CuentasRepository extends JpaRepository<Cuentas, Long> {

    List<Cuentas> findByRut(String rut);

}
