package com.autoparts.cartservice.controllers;

import com.autoparts.cartservice.entity.CartEntity;
import com.autoparts.cartservice.services.api.ICartServiceMicro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("micro/cart")
public class CartControllerMicro {
    private final ICartServiceMicro service;

    public CartControllerMicro(ICartServiceMicro service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<CartEntity>> get(@PathVariable("userId") UUID user) {
        return ResponseEntity.status(200).body(service.get(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> cleanCart(@PathVariable("userId") UUID user){
        service.clean(user);
        return ResponseEntity.status(204).build();
    }
}
