package com.autoparts.productservice.services;


import com.autoparts.productservice.core.ReqProductDTO;
import com.autoparts.productservice.core.exceptions.ProductNotFoundException;
import com.autoparts.productservice.entity.ProductEntity;
import com.autoparts.productservice.repositories.IProductRepository;
import com.autoparts.productservice.services.api.IProductServiceMicro;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceMicro implements IProductServiceMicro {
    private final IProductRepository repository;

    public ProductServiceMicro(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ProductEntity> find(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public void deCreaseAmount(ReqProductDTO req) {
        ProductEntity entity = repository.findById(req.productId())
                .orElseThrow(() -> new ProductNotFoundException("Product with id:" + req.productId() + " not found"));
        entity.setAmount(entity.getAmount() - req.amount());
        repository.save(entity);
    }
}
