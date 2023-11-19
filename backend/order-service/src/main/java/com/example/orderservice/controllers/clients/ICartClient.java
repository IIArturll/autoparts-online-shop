package com.example.orderservice.controllers.clients;

import com.example.orderservice.entity.cart.CartEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@FeignClient(value = "cart-service", path = "micro/cart")
public interface ICartClient {

    @GetMapping("/{userId}")
    ResponseEntity<Optional<CartEntity>> get(@PathVariable("userId") UUID user);

    @DeleteMapping("/{userId}")
    ResponseEntity<?> cleanCart(@PathVariable("userId") UUID user);
}
