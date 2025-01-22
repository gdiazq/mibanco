package com.mibanco.mcsv_clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mibanco.mcsv_clientes.model.Clientes;
import com.mibanco.mcsv_clientes.repository.ClientesRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ClientesServiceImpl implements ClientesService {
    
    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Clientes> findAll() {
        return clientesRepository.findAll();
    }
}
