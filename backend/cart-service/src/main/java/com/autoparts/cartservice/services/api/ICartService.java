package com.autoparts.cartservice.services.api;

import com.autoparts.cartservice.core.AddReq;
import com.autoparts.cartservice.core.CartDTO;
import com.autoparts.cartservice.core.ProductDTO;

import java.util.UUID;

public interface ICartService {
    CartDTO get(UUID user);
    void add(AddReq req);
}
