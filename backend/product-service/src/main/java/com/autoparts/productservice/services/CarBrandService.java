package com.autoparts.productservice.services;

import com.autoparts.productservice.core.exceptions.ResourceAlreadyExist;
import com.autoparts.productservice.entity.CarBrandEntity;
import com.autoparts.productservice.repositories.ICarBrandRepository;
import com.autoparts.productservice.services.api.ICarBrandService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CarBrandService implements ICarBrandService {
    private final ICarBrandRepository repository;

    public CarBrandService(ICarBrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public CarBrandEntity find(String brand) {
        return repository.findByBrandIgnoreCase(brand).orElse(null);
    }

    @Override
    public CarBrandEntity add(String brand) {
        Optional<CarBrandEntity> brandEntity = repository.findByBrandIgnoreCase(brand);
        if (brandEntity.isPresent()) {
            throw new ResourceAlreadyExist("Brand " + brand + " already exist");
        }
        CarBrandEntity entity = new CarBrandEntity(brand);
        repository.save(entity);
        return entity;
    }
}
