package com.autoparts.cartservice.services.api;

import com.autoparts.cartservice.core.ReqProductDTO;
import com.autoparts.cartservice.core.CartDTO;

import java.util.UUID;

public interface ICartService {
    CartDTO get(UUID user);
    void add(ReqProductDTO req);
    void delete(ReqProductDTO req);
}
