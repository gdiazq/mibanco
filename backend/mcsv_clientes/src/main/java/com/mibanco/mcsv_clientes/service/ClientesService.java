package com.mibanco.mcsv_clientes.service;

import java.util.List;

import com.mibanco.mcsv_clientes.dto.ClientesDto;
import com.mibanco.mcsv_clientes.model.Clientes;

public interface ClientesService {

    Iterable<Clientes> findAll();

    List<ClientesDto> findAllClientesWithCuentas();

}
