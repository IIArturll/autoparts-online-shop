package com.autoparts.cartservice.controllers.clients;

import com.autoparts.cartservice.entity.product.ProductEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@FeignClient(value = "product-service",path = "micro/product")
public interface IProductClient {
    @GetMapping("/{id}")
    ResponseEntity<Optional<ProductEntity>> getCard(@PathVariable UUID id);
}
