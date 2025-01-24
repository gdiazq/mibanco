package com.mibanco.mcsv_clientes.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mibanco.mcsv_clientes.dto.CuentasDto;

@FeignClient(name = "mcsv-cuentas")
public interface CuentasServiceClient {

    @GetMapping("/cuentas/all")
    List<CuentasDto> findAllClientesWithCuentas();

}
