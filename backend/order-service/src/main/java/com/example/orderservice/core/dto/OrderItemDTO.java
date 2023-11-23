package com.example.orderservice.core;

public class OrderItemDTO {
    private ProductDTO product;
    private Integer amount;

    public OrderItemDTO() {
    }

    public OrderItemDTO(ProductDTO productDTO, Integer amount) {
        this.product = productDTO;
        this.amount = amount;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
