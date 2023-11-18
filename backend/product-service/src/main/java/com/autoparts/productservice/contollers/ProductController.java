package com.autoparts.productservice.contollers;

import com.autoparts.productservice.core.ProductDTO;
import com.autoparts.productservice.core.ReqProductDTO;
import com.autoparts.productservice.core.SearchSpecificationDTO;
import com.autoparts.productservice.services.api.IProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
@Validated
public class ProductController {
    private final IProductService service;

    public ProductController(IProductService productService) {
        this.service = productService;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductDTO product) {
        service.add(product);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getPage(Pageable pageable,
                                                    @RequestBody SearchSpecificationDTO specification) {
        return ResponseEntity.status(200).body(service.getPage(pageable, specification));
    }

    @GetMapping("/card/{uuid}")
    public ResponseEntity<ProductDTO> getCard(@PathVariable("uuid") UUID uuid) {
        return ResponseEntity.status(200).body(service.find(uuid));
    }

    @PutMapping()
    public ResponseEntity<?> increaseAmount(@RequestBody ReqProductDTO req) {
        service.increaseAmount(req);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deIncreaseAmount(@RequestBody ReqProductDTO req) {
        service.deCreaseAmount(req);
        return ResponseEntity.status(204).build();
    }
}
