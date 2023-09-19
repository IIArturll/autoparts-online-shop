package com.autoparts.productservice.services.api;

import com.autoparts.productservice.entity.CategoryEntity;

public interface ICategoryService {
    CategoryEntity find(String category);
    CategoryEntity add(String category);
}
