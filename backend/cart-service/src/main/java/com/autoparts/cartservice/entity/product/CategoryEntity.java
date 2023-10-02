package com.autoparts.cartservice.entity.product;

import jakarta.persistence.*;

@Entity
@Table(schema = "autoparts_shop",name = "product_category")
public class CategoryEntity {
    @Id
    @GeneratedValue(generator = "category_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "category_seq", sequenceName = "product_category_id_seq",
            schema = "autoparts_shop", allocationSize = 1)
    private Short id;
    private String category;

    public CategoryEntity() {
    }

    public CategoryEntity(String category){
        this.category=category;
    }

    public Short getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

