package com.mibanco.mcsv_clientes.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CuentasDto {

    private Long cuenta_id;
    private String numero_cuenta;
    private TipoCuenta tipo_cuenta;

        public enum TipoCuenta {
            AHORRO, CORRIENTE, PLAZOFIJO
        }

    private BigDecimal saldo;
    private LocalDateTime fecha_apertura;
    private Estado estado;

        public enum Estado {
            ACTIVO, INACTIVO
        }

}
