package com.autoparts.productservice.repositories;

import com.autoparts.productservice.entity.CarBrandEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICarBrandRepository extends CrudRepository<CarBrandEntity,Short> {
    Optional<CarBrandEntity> findByBrandIgnoreCase(String brand);
}
