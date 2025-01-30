package com.mibanco.mcsv_auth.service;

import com.mibanco.mcsv_auth.dto.UsuariosLoginRequestDto;
import com.mibanco.mcsv_auth.dto.UsuariosLoginResponseDto;

public interface UsuarioLoginServiceInter {

    UsuariosLoginResponseDto authenticate(final UsuariosLoginRequestDto request);

}
