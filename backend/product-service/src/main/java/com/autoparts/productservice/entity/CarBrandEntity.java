package com.autoparts.productservice.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "autoparts_shop",name = "car_brand")
public class CarBrandEntity {
    @Id
    @GeneratedValue(generator = "brand_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "brand_seq", sequenceName = "car_brand_id_seq",
            schema = "autoparts_shop", allocationSize = 1)
    private Short id;
    private String brand;

    public CarBrandEntity() {

    }

    public CarBrandEntity(String brand) {
        this.brand = brand;
    }

    public Short getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
