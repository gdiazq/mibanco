package com.mibanco.mcsv_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) throws Exception {
        return http    
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeExchange(exchanges -> exchanges
                                .pathMatchers("/auth/**").permitAll()
                                .pathMatchers("/auth/welcome").authenticated()
                                .anyExchange().authenticated()
                )
            .oauth2ResourceServer(server -> server.jwt(Customizer.withDefaults()))
            .build();
    }
}
        
