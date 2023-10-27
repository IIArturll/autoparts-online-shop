package com.autoparts.productservice.repositories;

import com.autoparts.productservice.entity.CarBrandEntity;
import com.autoparts.productservice.entity.CategoryEntity;
import com.autoparts.productservice.entity.ProductEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IProductRepository extends CrudRepository<ProductEntity, UUID>,
        PagingAndSortingRepository<ProductEntity, UUID> {
    Optional<ProductEntity> findByTitleAndCategoryAndBrandAndDescriptionAndManufacturerAndPrice(@NotNull @NotBlank String title,
                                                                                                @NotNull CategoryEntity category,
                                                                                                @NotNull CarBrandEntity brand,
                                                                                                @NotNull @NotBlank String description,
                                                                                                @NotBlank String manufacturer,
                                                                                                @Positive Double price);
}
