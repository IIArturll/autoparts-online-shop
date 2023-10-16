package com.autoparts.cartservice.core;

import java.util.List;
import java.util.UUID;

public class CartDTO {
    private UUID id;
    private UUID user_id;
    private List<CartItemDTO> products;

    public CartDTO() {
    }

    public CartDTO(UUID id, UUID user_id, List<CartItemDTO> products) {
        this.id = id;
        this.user_id = user_id;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public List<CartItemDTO> getProducts() {
        return products;
    }

    public void setProducts(List<CartItemDTO> products) {
        this.products = products;
    }

    public void add(CartItemDTO cartItem) {
        this.products.add(cartItem);
    }

    public void add(ProductDTO product, Integer amount) {
        this.products.add(new CartItemDTO(product, amount));
    }
}
