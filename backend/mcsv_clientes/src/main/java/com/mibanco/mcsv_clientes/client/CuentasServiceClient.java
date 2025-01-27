package com.mibanco.mcsv_clientes.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mibanco.mcsv_clientes.dto.CuentasDto;

@FeignClient(name = "mcsv-cuentas", url = "http://localhost:8082")
public interface CuentasServiceClient {

    @GetMapping("/cuentas/all")
    List<CuentasDto> findAllClientesWithCuentas();

    @GetMapping("/cuentas/{rut}")
    CuentasDto getCuentasByRut(@PathVariable String rut);

}
