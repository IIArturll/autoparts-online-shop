package com.autoparts.cartservice.entity;

import com.autoparts.cartservice.entity.product.ProductEntity;
import com.autoparts.cartservice.entity.user.UserEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "autoparts_shop",name = "cart")
public class CartEntity {
    @Id
    private UUID id;
    @OneToOne
    private UserEntity user;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "cart_item", schema = "autoparts_shop",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<CartItemEntity> products;

    public CartEntity() {
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

    public void add(CartItemEntity cartItem){
        this.products.add(cartItem);
    }

    public void add(ProductEntity product,Integer amount){
        this.products.add(new CartItemEntity(product,amount));
    }
}
