package com.example.orderservice.services.api;

import com.example.orderservice.core.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IOrderService {
    void makeOrder(UUID user);

    Page<OrderDTO> getPageForUserWhereOrderIsReady(String userEmail, Pageable page);

    Page<OrderDTO> getPageOfOrdersWitchIsNotReady(Pageable page);

    Page<OrderDTO> getAllOrders(Pageable pageable);

    void markAsReady(UUID orderId);

    void issuanceOfOrder(UUID orderId);
}
