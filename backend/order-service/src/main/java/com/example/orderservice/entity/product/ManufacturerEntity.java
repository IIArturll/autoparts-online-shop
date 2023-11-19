package com.example.orderservice.entity.product;

import jakarta.persistence.*;

@Entity
@Table(schema = "autoparts_shop", name = "product_manufacturer")
public class ManufacturerEntity {
    @Id
    @GeneratedValue(generator = "manufacturer_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "manufacturer_seq", sequenceName = "product_manufacturer_id_seq",
            schema = "autoparts_shop", allocationSize = 1)
    private Short id;
    private String manufacturer;

    public ManufacturerEntity() {
    }

    public ManufacturerEntity(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Short getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
