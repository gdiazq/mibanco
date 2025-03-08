package com.mibanco.mcsv_auth.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class CognitoConfig {

    @Value("${spring.security.oauth2.client.registration.cognito.client-id}")
    private String userPoolId;

    @Value("${spring.security.oauth2.client.provider.cognito.issuerUri}")
    private String issuerUri;

    @Value("${spring.security.oauth2.client.registration.cognito.scope}")
    private List<String> scopes;

    public String getUserPoolId() {
        return issuerUri.substring(issuerUri.lastIndexOf('/') + 1);
    }

    public String getRegion() {
        String[] parts = issuerUri.split("\\.");
        return parts[1];
    }

    public String getJwkSetUri() {
        return issuerUri + "/.well-known/jwks.json";
    }

}
