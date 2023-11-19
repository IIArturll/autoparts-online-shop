package com.example.orderservice.entity;

import com.example.orderservice.entity.product.ProductEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "cart_order_item",schema = "autoparts_shop")
public class CartOrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    private Integer amount;

    public CartOrderItemEntity() {
    }

    public CartOrderItemEntity(ProductEntity product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
