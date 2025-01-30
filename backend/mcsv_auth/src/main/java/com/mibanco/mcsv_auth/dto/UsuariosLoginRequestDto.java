package com.mibanco.mcsv_auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuariosLoginRequestDto {

    private String usuario;
    private String password;

}
