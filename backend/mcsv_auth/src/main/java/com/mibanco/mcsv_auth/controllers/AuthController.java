package com.mibanco.mcsv_auth.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AuthController {

    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }
    
}
