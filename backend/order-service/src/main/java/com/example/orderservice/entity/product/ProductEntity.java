package com.example.orderservice.entity.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

@Entity
@Table(schema = "autoparts_shop", name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category")
    private CategoryEntity category;
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "car_brand")
    private CarBrandEntity brand;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manufacturer")
    private ManufacturerEntity manufacturer;
    @Column(name = "img_url")
    private String imgUrl;
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
                         ManufacturerEntity manufacturer, String imgUrl,
                         Double price, Integer amount) {
        this.title = title;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.manufacturer = manufacturer;
        this.imgUrl = imgUrl;
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

    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerEntity manufacturer) {
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
