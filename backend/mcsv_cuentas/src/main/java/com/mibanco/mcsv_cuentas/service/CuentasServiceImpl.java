package com.mibanco.mcsv_cuentas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mibanco.mcsv_cuentas.model.Cuentas;
import com.mibanco.mcsv_cuentas.repository.CuentasRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class CuentasServiceImpl implements CuentasService {

    @Autowired
    private CuentasRepository cuentasRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Cuentas> findAll() {
        return cuentasRepository.findAll();
    }

}
