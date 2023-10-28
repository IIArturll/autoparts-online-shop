package com.autoparts.productservice.services.api;

import com.autoparts.productservice.entity.ManufacturerEntity;

public interface IManufacturerService {
    ManufacturerEntity find(String manufacturer);

    ManufacturerEntity add(String manufacturer);
}
