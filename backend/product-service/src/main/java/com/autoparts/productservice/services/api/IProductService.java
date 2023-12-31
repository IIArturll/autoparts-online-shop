package com.autoparts.productservice.services.api;

import com.autoparts.productservice.core.dto.ProductDTO;
import com.autoparts.productservice.core.dto.ReqProductDTO;
import com.autoparts.productservice.core.dto.SearchSpecificationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IProductService {
    ProductDTO find(UUID uuid);

    Page<ProductDTO> getPage(Pageable pageable, SearchSpecificationDTO specification);

    void add(ProductDTO product);

    void increaseAmount(ReqProductDTO req);

    void decreaseAmount(ReqProductDTO req);
}
