package com.mibanco.mcsv_clientes.service;

import com.mibanco.mcsv_clientes.model.Clientes;

public interface ClientesService {

    Iterable<Clientes> findAll();

}
