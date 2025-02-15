package com.mibanco.mcsv_clientes.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ClientesDto {

    private Long cliente_id;
    private String nombre;
    private String apellido;
    private String rut;
    private List<CuentasDto> cuentas;
    private String fecha_nacimiento;
    private int edad;
    private String direccion;
    private String telefono;
    private String correo;
    private LocalDateTime fecha_registro;
    private Estado estado;

        public enum Estado {
            ACTIVO, INACTIVO
        }
        
}
