package com.autoparts.productservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.UUID;

@Entity
@Table(schema = "autoparts_shop", name = "product")
public class ProductEntity {
    @Id
    private UUID id;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "category")
    private CategoryEntity category;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "brand")
    private CarBrandEntity brand;
    @NotNull
    @NotBlank
    private String description;
    @Positive
    private Double price;
    @PositiveOrZero
    private Integer amount;

    public ProductEntity(UUID id, String title, CategoryEntity category,
                         CarBrandEntity brand, String description,
                         Double price, Integer amount) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public ProductEntity() {

    }

    public ProductEntity(String title, CategoryEntity category,
                         CarBrandEntity brand, String description,
                         Double price, Integer amount) {
        this.title = title;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public CarBrandEntity getBrand() {
        return brand;
    }

    public void setBrand(CarBrandEntity brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
