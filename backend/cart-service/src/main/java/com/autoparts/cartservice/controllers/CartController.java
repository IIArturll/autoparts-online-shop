package com.autoparts.cartservice.controllers;

import com.autoparts.cartservice.core.ReqProductDTO;
import com.autoparts.cartservice.core.CartDTO;
import com.autoparts.cartservice.services.api.ICartService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/cart")
@Validated
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
    public ResponseEntity<?> add(@RequestBody ReqProductDTO req) {
        service.add(req);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestBody ReqProductDTO req){
        service.delete(req);
        return ResponseEntity.status(204).build();
    }
}
