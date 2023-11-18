package com.example.orderservice.controllers;

import com.example.orderservice.services.api.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
@Validated
public class OrderController {

    private final IOrderService service;

    public OrderController(IOrderService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> makeOrder(@PathVariable("userId") UUID user) {
        service.makeOrder(user);
        return ResponseEntity.status(201).build();
    }

    //todo getPage of orders
    //todo get order by id
    //todo get all orders for user email
    //todo issue an order
    //todo mark order as ready by admin
}
