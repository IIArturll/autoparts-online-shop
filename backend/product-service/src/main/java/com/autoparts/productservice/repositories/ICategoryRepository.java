package com.autoparts.productservice.repositories;

import com.autoparts.productservice.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends CrudRepository<CategoryEntity,Short> {
    Optional<CategoryEntity> findByCategory(String category);
}
