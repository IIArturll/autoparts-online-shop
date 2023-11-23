package com.autoparts.userservice.controller;

import com.autoparts.userservice.entity.UserEntity;
import com.autoparts.userservice.service.MicroUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("micro/user")
public class MicroUserController {
    private final MicroUserService service;

    public MicroUserController(MicroUserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> get(@PathVariable("id") UUID id) {
        return ResponseEntity.status(200).body(service.get(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<UserEntity>> getByEmail(@PathVariable("email")
                                                           String email) {
        return ResponseEntity.status(200).body(service.getByEmail(email));
    }
}
