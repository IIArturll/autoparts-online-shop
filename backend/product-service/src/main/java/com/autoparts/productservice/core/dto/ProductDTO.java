package com.autoparts.productservice.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;


public class ProductDTO {
    private UUID id;

    @NotBlank
    private String title;
    @NotBlank
    private String category;
    @NotBlank
    private String brand;
    @NotBlank
    private String description;
    @NotBlank
    private String manufacturer;
    private String imgUrl;
    @Positive
    private Double price;
    @PositiveOrZero
    private Integer amount;


    public ProductDTO() {

    }

    public ProductDTO(UUID id, String title, String category,
                      String brand, String description,
                      String manufacturer, String url,
                      Double price, Integer amount) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.manufacturer = manufacturer;
        this.imgUrl = url;
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
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
