package com.autoparts.productservice.repositories;

import com.autoparts.productservice.entity.CarBrandEntity;
import com.autoparts.productservice.entity.CategoryEntity;
import com.autoparts.productservice.entity.ProductEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IProductRepository extends CrudRepository<ProductEntity, UUID>,
        PagingAndSortingRepository<ProductEntity, UUID>, JpaSpecificationExecutor<ProductEntity> {
    Optional<ProductEntity> findByTitleAndCategoryAndBrandAndDescriptionAndManufacturerAndPrice(@NotNull @NotBlank String title,
                                                                                                @NotNull CategoryEntity category,
                                                                                                @NotNull CarBrandEntity brand,
                                                                                                @NotNull @NotBlank String description,
                                                                                                @NotBlank String manufacturer,
                                                                                                @Positive Double price);

    default Page<ProductEntity> findProductsByFilters(String title, CarBrandEntity brand,
                                                      CategoryEntity category, Pageable page) {
        Specification<ProductEntity> spec = Specification.where(null);
        if (title != null && !title.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),
                            "%" + title.toLowerCase() + "%")
            );
        }
        if (brand != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("brand"), brand)
            );
        }
        if (category != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("category"), category)
            );
        }
        return findAll(spec, page);
    }
}
