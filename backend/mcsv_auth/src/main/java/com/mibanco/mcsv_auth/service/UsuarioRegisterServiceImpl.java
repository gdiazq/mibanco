package com.mibanco.mcsv_auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mibanco.mcsv_auth.model.Usuarios;
import com.mibanco.mcsv_auth.repository.UsuariosRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class UsuarioRegisterServiceImpl implements UsuarioRegisterServiceInter {

    private final UsuariosRepository usuariosRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public Usuarios registerUsuario(Usuarios usuarios) {
        if (usuariosRepository.existsByUsuario(usuarios.getUsuario()) || usuariosRepository.existsByCorreo(usuarios.getCorreo())) {
            throw new IllegalArgumentException("Usuario o Email already exists");
        }

        Usuarios usuario = new Usuarios();
        usuario.setUsuario(usuarios.getUsuario());
        usuario.setCorreo(usuarios.getCorreo());
        usuario.setPassword(passwordEncoder.encode(usuarios.getPassword()));

        return usuariosRepository.save(usuario);

    } 
}
