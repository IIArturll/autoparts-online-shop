package com.autoparts.cartservice.controllers.clients;

import com.autoparts.cartservice.core.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "product-service",path = "api/v1/product")
public interface IProductClient {
    @GetMapping("/card/{uuid}")
    ResponseEntity<ProductDTO> getCard(@PathVariable("uuid") UUID uuid);
}
