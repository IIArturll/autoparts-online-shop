package com.autoparts.cartservice.controllers;

import com.autoparts.cartservice.controllers.clients.IProductClient;
import com.autoparts.cartservice.core.AddProductDTO;
import com.autoparts.cartservice.core.CartDTO;
import com.autoparts.cartservice.services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {
    private final CartService service;
    private final IProductClient client;

    public CartController(CartService service, IProductClient client) {
        this.service = service;
        this.client = client;
    }

    // получить корзину пользователя по userId
    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> get(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(service.get(id));
    }

    // добавить в карзину продукт по productId для юзера по userId кол-во n
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody AddProductDTO req) {
        //service.add(userId,productId,amount)
        return ResponseEntity.status(201).build();
    }
}
