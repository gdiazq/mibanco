package com.mibanco.mcsv_auth.dto.mapper;

import org.springframework.stereotype.Component;

import com.mibanco.mcsv_auth.dto.UsuarioProfileDto;
import com.mibanco.mcsv_auth.model.Usuarios;

@Component
public class UsuarioMapper {

    public UsuarioProfileDto toUsuarioProfileDto(final Usuarios usuario) {
        return new UsuarioProfileDto(usuario.getCorreo(), usuario.getUsuario());
    }

}
