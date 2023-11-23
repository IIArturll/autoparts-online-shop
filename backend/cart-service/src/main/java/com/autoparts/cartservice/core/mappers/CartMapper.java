package com.autoparts.cartservice.core.mappers;

import com.autoparts.cartservice.core.dto.CartDTO;
import com.autoparts.cartservice.core.dto.CartItemDTO;
import com.autoparts.cartservice.core.dto.ProductDTO;
import com.autoparts.cartservice.entity.CartEntity;

public class CartMapper {
    public static CartDTO convertCartEntityToDTO(CartEntity entity) {
        CartDTO dto = new CartDTO();
        dto.setId(entity.getId());
        dto.setUser_id(entity.getUser().getId());
        dto.setProducts(entity.getProducts().stream().map(p -> new CartItemDTO(
                new ProductDTO(p.getProduct().getId(), p.getProduct().getTitle(),
                        p.getProduct().getCategory().getCategory(),
                        p.getProduct().getBrand().getBrand(),
                        p.getProduct().getDescription(),
                        p.getProduct().getPrice(),
                        p.getProduct().getAmount())
                , p.getAmount()
        )).toList());
        return dto;
    }
}
