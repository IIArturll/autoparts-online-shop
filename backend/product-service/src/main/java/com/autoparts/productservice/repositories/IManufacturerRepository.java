package com.autoparts.productservice.repositories;

import com.autoparts.productservice.entity.ManufacturerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IManufacturerRepository extends CrudRepository<ManufacturerEntity, Short> {
    Optional<ManufacturerEntity> findByManufacturerIgnoreCase(String manufacturer);
}
