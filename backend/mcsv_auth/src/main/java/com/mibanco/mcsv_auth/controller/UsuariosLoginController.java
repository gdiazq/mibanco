package com.mibanco.mcsv_auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mibanco.mcsv_auth.dto.UsuariosLoginRequestDto;
import com.mibanco.mcsv_auth.dto.UsuariosLoginResponseDto;
import com.mibanco.mcsv_auth.service.UsuarioLoginServiceInter;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class UsuariosLoginController {

    private final UsuarioLoginServiceInter usuarioLoginService;

    @PostMapping("/login")
    public ResponseEntity<UsuariosLoginResponseDto> autenticate (@RequestBody final UsuariosLoginRequestDto usuariosLoginRequestDto) {
            return ResponseEntity.ok(usuarioLoginService.authenticate(usuariosLoginRequestDto));
    }

}
