package com.autoparts.productservice.contollers;

import com.autoparts.productservice.core.ProductDTO;
import com.autoparts.productservice.services.api.IProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final IProductService service;

    public ProductController(IProductService productService) {
        this.service = productService;
    }

    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody ProductDTO product) {
        service.add(product);
        return ResponseEntity.status(201).build();
    }

    @GetMapping()
    public ResponseEntity<Page<ProductDTO>> getPage(Pageable pageable) {
        return ResponseEntity.status(200).body(service.getPage(pageable));
    }

    @GetMapping("/card/{uuid}")
    public ResponseEntity<ProductDTO> getCard(@PathVariable("uuid") UUID uuid) {
        return ResponseEntity.status(200).body(service.find(uuid));
    }
}
