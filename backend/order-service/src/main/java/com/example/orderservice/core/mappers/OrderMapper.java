package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.OrderDTO;
import com.example.orderservice.core.dto.OrderItemDTO;
import com.example.orderservice.core.dto.ProductDTO;
import com.example.orderservice.entity.OrderEntity;

public class OrderMapper {
    public static OrderDTO convertOrderEntityToDTO(OrderEntity entity) {
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUser().getId());
        dto.setReady(entity.getReady());
        dto.setOrderTime(entity.getOrderTime());
        dto.setIssuanceTime(entity.getIssuanceTime());
        dto.setProducts(entity.getProducts().stream().map(p -> new OrderItemDTO(
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
