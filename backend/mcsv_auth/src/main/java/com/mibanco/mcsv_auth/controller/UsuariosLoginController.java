package com.mibanco.mcsv_auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mibanco.mcsv_auth.dto.UsuariosLoginRequestDto;
import com.mibanco.mcsv_auth.dto.UsuariosLoginResponseDto;
import com.mibanco.mcsv_auth.service.UsuarioLoginServiceInter;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class UsuariosLoginController {

    private final UsuarioLoginServiceInter usuarioLoginService;

    @PostMapping("/login")
    public ResponseEntity<UsuariosLoginResponseDto> autenticate (@RequestBody final UsuariosLoginRequestDto usuariosLoginRequestDto) {
            return ResponseEntity.ok(usuarioLoginService.authenticate(usuariosLoginRequestDto));
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok("Bienvenido " + authentication.getName());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autenticado");
        }
    }


}
