package com.autoparts.cartservice.core;

public class CartItemDTO {
    private ProductDTO product;
    private Integer amount;

    public CartItemDTO() {
    }

    public CartItemDTO(ProductDTO productDTO, Integer amount) {
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
