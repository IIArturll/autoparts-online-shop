package com.example.orderservice.services.api;

import java.util.UUID;

public interface IOrderService {
    void makeOrder(UUID user);
}
