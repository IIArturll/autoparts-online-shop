package com.autoparts.productservice.services;

import com.autoparts.productservice.core.exceptions.ResourceAlreadyExist;
import com.autoparts.productservice.entity.ManufacturerEntity;
import com.autoparts.productservice.repositories.IManufacturerRepository;
import com.autoparts.productservice.services.api.IManufacturerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ManufacturerService implements IManufacturerService {
    private final IManufacturerRepository repository;

    public ManufacturerService(IManufacturerRepository repository) {
        this.repository = repository;
    }

    @Override
    public ManufacturerEntity find(String manufacturer) {
        return repository.findByManufacturerIgnoreCase(manufacturer).orElse(null);
    }

    @Override
    public ManufacturerEntity add(String manufacturer) {
        Optional<ManufacturerEntity> manufacturerEntity = repository.findByManufacturerIgnoreCase(manufacturer);
        if (manufacturerEntity.isPresent()) {
            throw new ResourceAlreadyExist("Manufacturer " + manufacturer + " already exist");
        }
        ManufacturerEntity entity = new ManufacturerEntity(manufacturer);
        repository.save(entity);
        return entity;
    }
}
