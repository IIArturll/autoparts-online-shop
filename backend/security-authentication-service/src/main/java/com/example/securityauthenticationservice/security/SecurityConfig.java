package com.example.securityauthenticationservice.security;

import com.example.securityauthenticationservice.jwt.JwtFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http = http
                .csrf().disable()
                .cors().disable()
                .formLogin().disable();
        http = http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
        http = http.
                exceptionHandling().authenticationEntryPoint((
                        (request, response, authException) ->
                                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)))
                .and().exceptionHandling().accessDeniedHandler((
                        (request, response, accessDeniedException) ->
                                response.setStatus(HttpServletResponse.SC_FORBIDDEN))).and();
        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/micro/**").access(
                                new WebExpressionAuthorizationManager("hasIpAddress('cart-service')"))
                        .requestMatchers("/micro/**").access(
                                new WebExpressionAuthorizationManager("hasIpAddress('order-service')"))
                        .requestMatchers("/micro/**").access(
                                new WebExpressionAuthorizationManager("hasIpAddress('security-authentication-service')"))
                        .requestMatchers(HttpMethod.POST, "/api/v1/product").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/product").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/product").hasRole("ADMIN")
                        .requestMatchers("/api/v1/product").permitAll()
                        .requestMatchers("/api/v1/product/**").permitAll()
                        .requestMatchers("/api/v1/cart/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/v1/order/**").authenticated()
                        .requestMatchers("/api/v1/order/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/user").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/v1/user/login").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/user").denyAll()
                        .requestMatchers("/api/v1/user/**").permitAll()
                );

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
