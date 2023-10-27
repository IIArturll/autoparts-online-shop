package com.autoparts.cartservice.services;

import com.autoparts.cartservice.controllers.clients.IProductClient;
import com.autoparts.cartservice.controllers.clients.IUserClient;
import com.autoparts.cartservice.core.AddProductDTO;
import com.autoparts.cartservice.core.CartDTO;
import com.autoparts.cartservice.core.CartMapper;
import com.autoparts.cartservice.core.exceptions.InsufficientQuantityException;
import com.autoparts.cartservice.core.exceptions.ProductNotFoundException;
import com.autoparts.cartservice.core.exceptions.UserNotFoundException;
import com.autoparts.cartservice.entity.CartEntity;
import com.autoparts.cartservice.entity.CartItemEntity;
import com.autoparts.cartservice.entity.product.ProductEntity;
import com.autoparts.cartservice.entity.user.UserEntity;
import com.autoparts.cartservice.repositories.ICartRepository;
import com.autoparts.cartservice.services.api.ICartService;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Bag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CartService implements ICartService {
    private final ICartRepository repository;
    private final IProductClient productClient;
    private final IUserClient userClient;

    public CartService(ICartRepository repository, IProductClient productClient,
                       IUserClient userClient) {
        this.repository = repository;
        this.productClient = productClient;
        this.userClient = userClient;
    }

    @Override
    public CartDTO get(UUID user) {
        UserEntity userEntity = userClient.get(user).getBody()
                .orElseThrow(() -> new UserNotFoundException("User with id: " + user + ", not found"));
        CartEntity cartEntity = repository.findByUserId(user).orElseGet(() -> new CartEntity(userEntity));
        return CartMapper.convertCartEntityToDTO(cartEntity);
    }

    @Override
    public void add(AddProductDTO req) {
        ProductEntity product = productClient.getCard(req.productId()).getBody()
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + req.productId() + ", not found"));
        UserEntity user = userClient.get(req.userId()).getBody()
                .orElseThrow(() -> new UserNotFoundException("User with id: " + req.userId() + ", not found"));
        CartEntity cartEntity = repository.findByUserId(user.getId()).orElseGet(() -> new CartEntity(user));
        cartEntity.add(product, req.amount());
        repository.save(cartEntity);
    }
}
