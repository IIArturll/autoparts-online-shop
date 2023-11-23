package com.autoparts.productservice.core;

import com.autoparts.productservice.entity.CarBrandEntity;
import com.autoparts.productservice.entity.CategoryEntity;
import com.autoparts.productservice.entity.ManufacturerEntity;
import com.autoparts.productservice.entity.ProductEntity;

public class ProductMapper {
    public static ProductDTO convertProductEntityToDTO(ProductEntity entity) {
        return new ProductDTO(entity.getId(), entity.getTitle(), entity.getCategory().getCategory(),
                entity.getBrand().getBrand(), entity.getDescription(),
                entity.getManufacturer().getManufacturer(), entity.getImgUrl(),
                entity.getPrice(), entity.getAmount());
    }

    public static ProductEntity convertProductDTOToEntity(ProductDTO dto) {
        return new ProductEntity(dto.getTitle(), new CategoryEntity(dto.getCategory()),
                new CarBrandEntity(dto.getBrand()), dto.getDescription(),
                new ManufacturerEntity(dto.getManufacturer()), dto.getImgUrl(),
                dto.getPrice(), dto.getAmount());
    }
}
