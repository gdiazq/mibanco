package com.mibanco.mcsv_auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String privateKey;
    private String publicKey;
    private String ttl;

}
