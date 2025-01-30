package com.mibanco.mcsv_auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuariosRegisterRequestDto {

    private String correo;
    private String usuario;
    private String password;

}
