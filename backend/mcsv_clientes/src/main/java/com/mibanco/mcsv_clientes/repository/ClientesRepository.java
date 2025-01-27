package com.mibanco.mcsv_clientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mibanco.mcsv_clientes.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

    List<Clientes> findByRut(String rut);
    
}