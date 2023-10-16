package com.autoparts.cartservice.services;

import com.autoparts.cartservice.controllers.clients.IProductClient;
import com.autoparts.cartservice.core.AddProductDTO;
import com.autoparts.cartservice.core.CartDTO;
import com.autoparts.cartservice.core.CartMapper;
import com.autoparts.cartservice.core.ProductDTO;
import com.autoparts.cartservice.entity.CartEntity;
import com.autoparts.cartservice.repositories.ICartRepository;
import com.autoparts.cartservice.services.api.ICartService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class CartService implements ICartService {
    private final ICartRepository repository;
    private final IProductClient productClient;
    public CartService(ICartRepository repository, IProductClient productClient) {
        this.repository = repository;
        this.productClient = productClient;
    }

    @Override
    public CartDTO get(UUID user) {
        CartEntity cartEntity = repository.findByUserId(user).orElseThrow(() ->
                new RuntimeException("no have cart for this user"));
        return CartMapper.convertCartEntityToDTO(cartEntity);
    }

    @Override
    public void add(AddProductDTO req) {
    }
}
