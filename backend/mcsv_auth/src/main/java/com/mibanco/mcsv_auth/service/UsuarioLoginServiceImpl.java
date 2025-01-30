package com.mibanco.mcsv_auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.mibanco.mcsv_auth.dto.UsuariosLoginRequestDto;
import com.mibanco.mcsv_auth.dto.UsuariosLoginResponseDto;
import com.mibanco.mcsv_auth.jwt.JwtService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class UsuarioLoginServiceImpl implements UsuarioLoginServiceInter {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public UsuariosLoginResponseDto authenticate(final UsuariosLoginRequestDto request) {
        final var authToken = UsernamePasswordAuthenticationToken
            .unauthenticated(request.getUsuario(), request.getPassword());

            authenticationManager.authenticate(authToken);
            final var token = jwtService.generateToken(request.getUsuario());
            return new UsuariosLoginResponseDto(token);
    }

}
