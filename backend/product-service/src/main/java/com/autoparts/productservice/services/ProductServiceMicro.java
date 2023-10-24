package com.autoparts.productservice.services;


import com.autoparts.productservice.core.exceptions.ProductNotFoundException;
import com.autoparts.productservice.entity.ProductEntity;
import com.autoparts.productservice.repositories.IProductRepository;
import com.autoparts.productservice.services.api.IProductServiceMicro;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class ProductServiceMicro implements IProductServiceMicro {
    private final IProductRepository repository;

    public ProductServiceMicro(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductEntity find(UUID uuid) {
        return repository.findById(uuid).orElseThrow(() ->
                new ProductNotFoundException("There is no product with this id : " + uuid));
    }
}
