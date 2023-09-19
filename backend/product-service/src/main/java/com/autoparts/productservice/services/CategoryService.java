package com.autoparts.productservice.services;

import com.autoparts.productservice.entity.CategoryEntity;
import com.autoparts.productservice.repositories.ICategoryRepository;
import com.autoparts.productservice.services.api.ICategoryService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService implements ICategoryService {

    private final ICategoryRepository repository;

    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryEntity find(String category) {
        return repository.findByCategory(category).orElse(null);
    }

    @Override
    public CategoryEntity add(String category) {
        CategoryEntity entity = new CategoryEntity(category);
        repository.save(entity);
        return entity;
    }
}
