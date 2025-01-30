package com.mibanco.mcsv_auth.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mibanco.mcsv_auth.repository.UsuariosRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(final String usuario) throws UsernameNotFoundException {
        
        return usuariosRepository.findByUsuario(usuario).map(user ->
            User.builder()
                .username(usuario)
                .password(user.getPassword())
                .build()
        ).orElseThrow(() -> new UsernameNotFoundException("User with username [%s] not found".formatted(usuario)));

    }

}
