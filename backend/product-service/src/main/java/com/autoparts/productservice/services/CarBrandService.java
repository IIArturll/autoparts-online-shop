package com.autoparts.productservice.services;

import com.autoparts.productservice.entity.CarBrandEntity;
import com.autoparts.productservice.repositories.ICarBrandRepository;
import com.autoparts.productservice.services.api.ICarBrandService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CarBrandService implements ICarBrandService {
    private final ICarBrandRepository repository;

    public CarBrandService(ICarBrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public CarBrandEntity find(String brand) {
        return repository.findByBrand(brand).orElse(null);
    }

    @Override
    public CarBrandEntity add(String brand) {
        CarBrandEntity entity=new CarBrandEntity(brand);
        repository.save(entity);
        return entity;
    }
}
