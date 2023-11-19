package com.autoparts.cartservice.services;

import com.autoparts.cartservice.entity.CartEntity;
import com.autoparts.cartservice.repositories.ICartRepository;
import com.autoparts.cartservice.services.api.ICartServiceMicro;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CartServiceMicro implements ICartServiceMicro {
    private final ICartRepository repository;

    public CartServiceMicro(ICartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<CartEntity> get(UUID user) {
        return repository.findByUserId(user);
    }

    @Override
    public void clean(UUID user) {
        CartEntity cartEntity = repository.findByUserId(user).get();
        cartEntity.setProducts(new ArrayList<>());
        repository.save(cartEntity);
    }
}
