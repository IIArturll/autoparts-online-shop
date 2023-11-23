package com.example.orderservice.core;

import com.example.orderservice.entity.CartOrderItemEntity;
import com.example.orderservice.entity.user.UserEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderDTO {
    private UUID id;
    private UUID userId;
    private LocalDateTime orderTime;
    private Boolean ready;
    private LocalDateTime issuanceTime;
    private List<OrderItemDTO> products;

    public OrderDTO() {
    }

    public OrderDTO(UUID id, UUID userId, LocalDateTime orderTime, Boolean ready,
                    LocalDateTime issuanceTime, List<OrderItemDTO> products) {
        this.id = id;
        this.userId = userId;
        this.orderTime = orderTime;
        this.ready = ready;
        this.issuanceTime = issuanceTime;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public LocalDateTime getIssuanceTime() {
        return issuanceTime;
    }

    public void setIssuanceTime(LocalDateTime issuanceTime) {
        this.issuanceTime = issuanceTime;
    }

    public List<OrderItemDTO> getProducts() {
        return products;
    }

    public void setProducts(List<OrderItemDTO> products) {
        this.products = products;
    }
}
