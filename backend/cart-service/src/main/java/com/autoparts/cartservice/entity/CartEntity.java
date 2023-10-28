package com.autoparts.cartservice.entity;

import com.autoparts.cartservice.core.exceptions.InsufficientQuantityException;
import com.autoparts.cartservice.entity.product.ProductEntity;
import com.autoparts.cartservice.entity.user.UserEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "autoparts_shop", name = "cart")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    private UserEntity user;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "cart_product", schema = "autoparts_shop",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_item_id"))
    private List<CartItemEntity> products;

    public CartEntity() {
        this.products = new ArrayList<>();
    }

    public CartEntity(UserEntity user) {
        this.user = user;
        this.products=new ArrayList<>();
    }

    public CartEntity(UUID id, UserEntity user, List<CartItemEntity> products) {
        this.id = id;
        this.user = user;
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

    public List<CartItemEntity> getProducts() {
        return products;
    }

    public void setProducts(List<CartItemEntity> products) {
        this.products = products;
    }

    public void add(CartItemEntity cartItem) {
        if (this.products == null) {
            products = new ArrayList<>();
        }
        ProductEntity product = cartItem.getProduct();
        CartItemEntity existingItem = findCartWithProduct(product);
        if (existingItem != null) {
            Integer newAmount = existingItem.getAmount() + cartItem.getAmount();
            if (newAmount > product.getAmount()) {
                throw new InsufficientQuantityException("Exceeded the possible amount. Available "
                        + (product.getAmount() - existingItem.getAmount()) + " unit(s)");
            }
            existingItem.setAmount(newAmount);
        } else {
            if (cartItem.getAmount() > product.getAmount()) {
                throw new InsufficientQuantityException("Exceeded the possible amount. Available "
                        + product.getAmount() + " unit(s)");
            }
            this.products.add(cartItem);
        }
    }

    public void add(ProductEntity product, Integer amount) {
        this.add(new CartItemEntity(product, amount));
    }

    private CartItemEntity findCartWithProduct(ProductEntity product) {
        return products.stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);
    }

}
