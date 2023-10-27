package com.autoparts.cartservice.controllers;

import com.autoparts.cartservice.core.AddProductDTO;
import com.autoparts.cartservice.core.CartDTO;
import com.autoparts.cartservice.services.api.ICartService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {
    private final ICartService service;

    public CartController(ICartService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> get(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(service.get(id));
    }
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody @Valid AddProductDTO req) {
        service.add(req);
        return ResponseEntity.status(201).build();
    }
}
