package com.autoparts.productservice.services.api;

import com.autoparts.productservice.core.dto.ReqProductDTO;
import com.autoparts.productservice.entity.ProductEntity;

import java.util.Optional;
import java.util.UUID;

public interface IProductServiceMicro {
    Optional<ProductEntity> find(UUID uuid);
    void deCreaseAmount(ReqProductDTO req);
}
