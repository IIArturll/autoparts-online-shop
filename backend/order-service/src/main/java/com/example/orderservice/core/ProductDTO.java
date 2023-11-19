package com.example.orderservice.core;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;


public class ProductDTO {
    private UUID id;

    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String category;
    @NotNull
    @NotBlank
    private String brand;
    @NotNull
    @NotBlank
    private String description;
    @Positive
    private Double price;
    @PositiveOrZero
    private Integer amount;

    public ProductDTO() {

    }

    public ProductDTO(UUID id, String title, String category,
                      String brand, String description,
                      Double price, Integer amount) {
        this.id=id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
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
