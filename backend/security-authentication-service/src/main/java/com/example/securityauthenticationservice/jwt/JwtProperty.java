package com.example.securityauthenticationservice.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "token")
public class JwtProperty {
    private String jwtIssuer;
    private String jwtSecret;
    private Duration jwtLifetime;

    public String getJwtIssuer() {
        return jwtIssuer;
    }
    public void setJwtIssuer(String jwtIssuer) {
        this.jwtIssuer = jwtIssuer;
    }
    public String getJwtSecret() {
        return jwtSecret;
    }
    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }
    public Duration getJwtLifetime() {
        return jwtLifetime;
    }
    public void setJwtLifetime(Duration jwtLifetime) {
        this.jwtLifetime = jwtLifetime;
    }
}
