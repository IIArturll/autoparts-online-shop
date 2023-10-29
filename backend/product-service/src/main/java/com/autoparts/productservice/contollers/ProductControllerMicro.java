package com.autoparts.productservice.contollers;

import com.autoparts.productservice.entity.ProductEntity;
import com.autoparts.productservice.services.ProductServiceMicro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/micro/product")
public class ProductControllerMicro {
    private final ProductServiceMicro service;

    public ProductControllerMicro(ProductServiceMicro service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductEntity>> getCard(@PathVariable UUID id){
        return ResponseEntity.status(200).body(service.find(id));
    }
}
