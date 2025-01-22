package com.mibanco.mcsv_cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mibanco.mcsv_cuentas.model.Cuentas;

public interface CuentasRepository extends JpaRepository<Cuentas, Long> {

}
