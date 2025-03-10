package com.mibanco.mcsv_auth.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping
public class AuthController {

    @GetMapping("/welcome")
     public ResponseEntity<Map<String, Object>> welcome(@AuthenticationPrincipal Jwt jwt) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "¡Este es un endpoint protegido! Autenticación exitosa.");
        String username = jwt.getClaimAsString("cognito:username");
        if (username != null) {
            response.put("username", username);
        }
        String email = jwt.getClaimAsString("email");
        if (email != null) {
            response.put("email", email);
        }
        return ResponseEntity.ok(response);
    }
    
}
