package com.autoparts.cartservice.services.api;

import com.autoparts.cartservice.core.dto.ReqProductDTO;
import com.autoparts.cartservice.core.dto.CartDTO;

import java.util.UUID;

public interface ICartService {
    CartDTO get(UUID user);
    void add(ReqProductDTO req);
    void delete(ReqProductDTO req);
}
