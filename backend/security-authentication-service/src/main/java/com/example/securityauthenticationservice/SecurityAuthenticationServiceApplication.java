package com.example.securityauthenticationservice;

import com.example.securityauthenticationservice.jwt.JwtProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties({JwtProperty.class})
public class SecurityAuthenticationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityAuthenticationServiceApplication.class, args);
    }
}
