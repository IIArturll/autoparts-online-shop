package com.example.orderservice.entity;

import com.example.orderservice.entity.user.UserEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order", schema = "autoparts_shop")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private UserEntity user;
    @Column(name = "order_time")
    private LocalDateTime orderTime;
    private Boolean ready;
    @Column(name = "issuance_time")
    private LocalDateTime issuanceTime;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "order_product", schema = "autoparts_shop",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_item_id"))
    private List<CartOrderItemEntity> products;

    public OrderEntity() {
    }

    public OrderEntity(UserEntity user, LocalDateTime orderTime, Boolean ready, List<CartOrderItemEntity> products) {
        this.user = user;
        this.orderTime = orderTime;
        this.ready = ready;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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

    public List<CartOrderItemEntity> getProducts() {
        return products;
    }

    public void setProducts(List<CartOrderItemEntity> products) {
        this.products = products;
    }
}
