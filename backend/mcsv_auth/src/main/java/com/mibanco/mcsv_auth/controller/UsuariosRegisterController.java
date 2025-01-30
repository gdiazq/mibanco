package com.mibanco.mcsv_auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mibanco.mcsv_auth.dto.UsuariosRegisterRequestDto;
import com.mibanco.mcsv_auth.dto.UsuariosRegisterResponseDto;
import com.mibanco.mcsv_auth.dto.mapper.AuthUsuarioRegisterMapper;
import com.mibanco.mcsv_auth.service.UsuarioRegisterServiceInter;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class UsuariosRegisterController {

    private final UsuarioRegisterServiceInter usuarioRegisterService;
    private final AuthUsuarioRegisterMapper usuarioRegisterMapper;

    @PostMapping("/register")
    public ResponseEntity<UsuariosRegisterResponseDto> registerUsuario(
        @Validated @RequestBody final UsuariosRegisterRequestDto registerDto) {

            final var registerUser = usuarioRegisterService.registerUsuario(
                usuarioRegisterMapper.toUsuarios(registerDto));
            
            return ResponseEntity.ok(usuarioRegisterMapper.toUsuariosRegisterResponseDto(registerUser));
        }
        
}
