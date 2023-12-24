package com.example.orderservice.core.mappers;

import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.entity.cart.CartEntity;

import java.time.LocalDateTime;

public class CartOrderEntityMapper {
    public static OrderEntity cartToOrderEntity(CartEntity cart) {
        return new OrderEntity(cart.getUser(), LocalDateTime.now(), false, cart.getProducts());
    }
}
