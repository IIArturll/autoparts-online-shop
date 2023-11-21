package com.example.securityauthenticationservice.controllers;

import com.example.securityauthenticationservice.core.dtos.UserLoginDTO;
import com.example.securityauthenticationservice.security.api.IAuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Validated
public class AuthenticationController {
    private final IAuthenticationService service;

    public AuthenticationController(IAuthenticationService authenticationService) {
        this.service = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO user) {
        return ResponseEntity.status(200).body(service.login(user));
    }
}
