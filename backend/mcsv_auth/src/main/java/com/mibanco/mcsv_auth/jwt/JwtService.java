package com.mibanco.mcsv_auth.jwt;

import java.time.Instant;
import java.time.Duration;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtService {

    private final String issuer;
    private final Duration ttl;
    private final JwtEncoder jwtEncoder;

    //Genera un token JWT con el nombre de usuario
    public String generateToken(final String usuario) {
        final var claimsSet = JwtClaimsSet.builder()
            .subject(usuario)
            .issuer(issuer)
            .expiresAt(Instant.now().plus(ttl))
            .build();
        
            return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet))
                .getTokenValue();

            

    }


}
