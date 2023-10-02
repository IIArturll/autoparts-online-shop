package com.autoparts.cartservice.core;

public class CartItemDTO {
    private ProductDTO productDTO;
    private Integer amount;

    public CartItemDTO() {
    }

    public CartItemDTO(ProductDTO productDTO, Integer amount) {
        this.productDTO = productDTO;
        this.amount = amount;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
