package com.autoparts.productservice.contollers;

import com.autoparts.productservice.core.dto.ProductDTO;
import com.autoparts.productservice.core.dto.ReqProductDTO;
import com.autoparts.productservice.core.dto.SearchSpecificationDTO;
import com.autoparts.productservice.services.api.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
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
                                                    @RequestParam("title") String title,
                                                    @RequestParam("brand") String brand,
                                                    @RequestParam("category") String category) {
        SearchSpecificationDTO specification = new SearchSpecificationDTO(title, brand, category);
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
    public ResponseEntity<?> decreaseAmount(@RequestBody ReqProductDTO req) {
        service.decreaseAmount(req);
        return ResponseEntity.status(204).build();
    }
}
