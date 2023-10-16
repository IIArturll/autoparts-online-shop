package com.autoparts.productservice.services.api;

import com.autoparts.productservice.entity.ProductEntity;

import java.util.UUID;

public interface IProductServiceMicro {
    ProductEntity find(UUID uuid);
}
