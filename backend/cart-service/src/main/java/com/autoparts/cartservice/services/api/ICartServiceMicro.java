package com.autoparts.cartservice.services.api;

import com.autoparts.cartservice.entity.CartEntity;

import java.util.Optional;
import java.util.UUID;

public interface ICartServiceMicro {
    Optional<CartEntity> get(UUID user);

    void clean(UUID user);
}
