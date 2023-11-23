package com.autoparts.productservice.services;

import com.autoparts.productservice.core.dto.ProductDTO;
import com.autoparts.productservice.core.mappers.ProductMapper;
import com.autoparts.productservice.core.dto.ReqProductDTO;
import com.autoparts.productservice.core.dto.SearchSpecificationDTO;
import com.autoparts.productservice.core.exceptions.ResourceNotFoundException;
import com.autoparts.productservice.core.exceptions.ResourceAlreadyExist;
import com.autoparts.productservice.entity.CarBrandEntity;
import com.autoparts.productservice.entity.CategoryEntity;
import com.autoparts.productservice.entity.ManufacturerEntity;
import com.autoparts.productservice.entity.ProductEntity;
import com.autoparts.productservice.repositories.IProductRepository;
import com.autoparts.productservice.services.api.ICarBrandService;
import com.autoparts.productservice.services.api.ICategoryService;
import com.autoparts.productservice.services.api.IManufacturerService;
import com.autoparts.productservice.services.api.IProductService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@Transactional
public class ProductService implements IProductService {
    private final IProductRepository repository;
    private final ICategoryService categoryService;
    private final ICarBrandService brandService;
    private final IManufacturerService manufacturerService;

    public ProductService(IProductRepository repository,
                          ICategoryService categoryService,
                          ICarBrandService brandService, IManufacturerService manufacturerService) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.manufacturerService = manufacturerService;
    }

    @Override
    public ProductDTO find(UUID uuid) {
        ProductEntity productEntity = repository.findById(uuid).orElseThrow(() ->
                new ResourceNotFoundException("There is no product with this id : " + uuid));
        return ProductMapper.convertProductEntityToDTO(productEntity);
    }

    @Override
    public Page<ProductDTO> getPage(Pageable pageable, SearchSpecificationDTO specification) {
        CategoryEntity category = null;
        if (specification.category() != null && !specification.category().isEmpty()) {
            category = categoryService.find(specification.category());
            if (category == null) {
                category = categoryService.add(specification.category());
            }
        }
        CarBrandEntity brand = null;
        if (specification.brand() != null && !specification.brand().isEmpty()) {
            brand = brandService.find(specification.brand());
            if (brand == null) {
                brand = brandService.add(specification.brand());
            }
        }
        return repository.findProductsByFilters(specification.title(), brand, category, pageable)
                .map(ProductMapper::convertProductEntityToDTO);
    }

    @Override
    public void add(ProductDTO product) {
        CategoryEntity category = categoryService.find(product.getCategory());
        if (category == null) {
            category = categoryService.add(product.getCategory());
        }
        CarBrandEntity brand = brandService.find(product.getBrand());
        if (brand == null) {
            brand = brandService.add(product.getBrand());
        }
        ManufacturerEntity manufacturer = manufacturerService.find(product.getManufacturer());
        if (manufacturer == null) {
            manufacturer = manufacturerService.add(product.getManufacturer());
        }
        ProductEntity existProduct = repository.findByTitleAndCategoryAndBrandAndDescriptionAndManufacturerAndPrice(
                product.getTitle(),
                category,
                brand,
                product.getDescription(),
                manufacturer,
                product.getPrice()
        ).orElse(null);
        if (existProduct != null)
            throw new ResourceAlreadyExist("Product with this parameters already exist, with id " + existProduct.getId());
        ProductEntity entity = ProductMapper.convertProductDTOToEntity(product);
        entity.setCategory(category);
        entity.setBrand(brand);
        entity.setManufacturer(manufacturer);
        repository.save(entity);
    }

    @Override
    public void increaseAmount(ReqProductDTO req) {
        ProductEntity entity = repository.findById(req.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Product with id:" + req.productId()+ " not found"));
        entity.setAmount(entity.getAmount() + req.amount());
        repository.save(entity);
    }

    @Override
    public void decreaseAmount(ReqProductDTO req) {
        ProductEntity entity = repository.findById(req.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Product with id:" + req.productId() + " not found"));
        entity.setAmount(entity.getAmount() - req.amount());
        repository.save(entity);
    }
}
