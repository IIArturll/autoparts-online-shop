package com.autoparts.productservice.services.api;

import com.autoparts.productservice.entity.CarBrandEntity;

public interface ICarBrandService {
    CarBrandEntity find(String brand);
    CarBrandEntity add(String brand);
}
