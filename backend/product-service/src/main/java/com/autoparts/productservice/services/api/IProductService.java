package com.autoparts.productservice.services.api;

import com.autoparts.productservice.core.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IProductService {
    ProductDTO find(UUID uuid);

    Page<ProductDTO> getPage(Pageable pageable);

    void add(ProductDTO product);

    void increaseAmount(UUID id, Integer amount);
}
