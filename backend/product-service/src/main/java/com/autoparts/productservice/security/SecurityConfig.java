package com.autoparts.productservice.security;

import com.autoparts.productservice.security.jwt.JwtFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);

        http.sessionManagement(sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.exceptionHandling((exceptionHandling) ->
                exceptionHandling.authenticationEntryPoint((
                        (request, response, authException) ->
                                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED))));
        http.exceptionHandling(exceptionHandling ->
                exceptionHandling.accessDeniedHandler((
                        (request, response, accessDeniedException) ->
                                response.setStatus(HttpServletResponse.SC_FORBIDDEN))));
        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/micro/**").access(
//                                new WebExpressionAuthorizationManager("hasIpAddress('cart-service')"))
//                        .requestMatchers("/micro/**").access(
//                                new WebExpressionAuthorizationManager("hasIpAddress('order-service')"))
                                .requestMatchers("/micro/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/product").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/product").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/product").hasRole("ADMIN")
                                .requestMatchers("/api/v1/product").permitAll()
                                .requestMatchers("/api/v1/product/card/**").permitAll()
                );

        return http.build();
    }

}
