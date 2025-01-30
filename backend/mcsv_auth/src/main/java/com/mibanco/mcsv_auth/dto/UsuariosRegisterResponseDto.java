package com.mibanco.mcsv_auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuariosRegisterResponseDto {

    private String usuario;
    private String correo;

}
