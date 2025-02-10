package com.mibanco.mcsv_auth.jwt;

import java.time.Instant;
import java.time.Duration;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

@Component
public class JwtService {

    private final String issuer;

    private final Duration ttl;

    private final JwtEncoder jwtEncoder;

    private final JwtDecoder jwtDecoder;

    public JwtService(final String issuer, final Duration ttl, final JwtEncoder jwtEncoder, final JwtDecoder jwtDecoder) {
        this.issuer = issuer;
        this.ttl = ttl;
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
    }

    //Genera un token JWT con el nombre de usuario

    public String generateToken(final String username) {
        final var claimsSet = JwtClaimsSet.builder()
            .subject(username)
            .issuer(issuer)
            .expiresAt(Instant.now().plus(ttl))
            .build();
        
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet))
            .getTokenValue();
    }

    //Valida un token JWT

    public boolean validateToken(final String token) {
        try {
            jwtDecoder.decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
