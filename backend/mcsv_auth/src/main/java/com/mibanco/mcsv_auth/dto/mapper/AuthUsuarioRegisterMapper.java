package com.mibanco.mcsv_auth.dto.mapper;

import org.springframework.stereotype.Component;

import com.mibanco.mcsv_auth.dto.UsuariosRegisterRequestDto;
import com.mibanco.mcsv_auth.dto.UsuariosRegisterResponseDto;
import com.mibanco.mcsv_auth.model.Usuarios;

@Component
public class AuthUsuarioRegisterMapper {

    public Usuarios toUsuarios(UsuariosRegisterRequestDto usuariosRegisterRequestDto) {
        final var usuario = new Usuarios();
        usuario.setCorreo(usuariosRegisterRequestDto.getCorreo());
        usuario.setUsuario(usuariosRegisterRequestDto.getUsuario());
        usuario.setPassword(usuariosRegisterRequestDto.getPassword());
        return usuario;
    }

    public UsuariosRegisterResponseDto toUsuariosRegisterResponseDto(final Usuarios usuarios) {
        return new UsuariosRegisterResponseDto(
            usuarios.getUsuario(),
            usuarios.getCorreo()
        );
    }

}
