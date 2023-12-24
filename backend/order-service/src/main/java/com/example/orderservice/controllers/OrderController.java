package com.example.orderservice.controllers;

import com.example.orderservice.core.dto.OrderDTO;
import com.example.orderservice.services.api.IOrderService;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
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


    @GetMapping("/{email}")
    public ResponseEntity<Page<OrderDTO>> getOrdersForUser(Pageable page,
                                                           @PathVariable
                                                           @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
                                                                   message = "illegal format of email,correct example: email@mail.ru , google@gmail.com")
                                                           String email) {
        return ResponseEntity.status(200).body(
                service.getPageForUserWhereOrderIsReady(email, page));

    }

    @GetMapping("/collect")
    public ResponseEntity<Page<OrderDTO>> getOrdersForCollect(Pageable page) {
        return ResponseEntity.status(200).body(service.getPageOfOrdersWitchIsNotReady(page));
    }

    @GetMapping()
    public ResponseEntity<Page<OrderDTO>> getAll(Pageable page) {
        return ResponseEntity.status(200).body(service.getAllOrders(page));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<?> markAsReady(@PathVariable UUID orderId) {
        service.markAsReady(orderId);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/issuance/{orderId}")
    public ResponseEntity<?> issuanceOfOrder(@PathVariable UUID orderId) {
        service.issuanceOfOrder(orderId);
        return ResponseEntity.status(200).build();
    }
}
