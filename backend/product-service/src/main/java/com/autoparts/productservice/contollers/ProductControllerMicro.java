package com.autoparts.productservice.contollers;

import com.autoparts.productservice.core.dto.ReqProductDTO;
import com.autoparts.productservice.entity.ProductEntity;
import com.autoparts.productservice.services.ProductServiceMicro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Optional<ProductEntity>> getCard(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(service.find(id));
    }

    @DeleteMapping()
    public ResponseEntity<?> deCreaseAmount(@RequestBody ReqProductDTO req) {
        service.deCreaseAmount(req);
        return ResponseEntity.status(204).build();
    }
}
