package com.autoparts.cartservice.services.api;

import com.autoparts.cartservice.core.AddProductDTO;
import com.autoparts.cartservice.core.CartDTO;

import java.util.UUID;

public interface ICartService {
    CartDTO get(UUID user);
    void add(AddProductDTO req);
}
