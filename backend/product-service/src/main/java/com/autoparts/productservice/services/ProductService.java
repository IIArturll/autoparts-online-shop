package com.autoparts.productservice.services;

import com.autoparts.productservice.core.ProductDTO;
import com.autoparts.productservice.core.ProductMapper;
import com.autoparts.productservice.core.exceptions.ProductNotFoundException;
import com.autoparts.productservice.core.exceptions.ResourceAlreadyExist;
import com.autoparts.productservice.entity.CarBrandEntity;
import com.autoparts.productservice.entity.CategoryEntity;
import com.autoparts.productservice.entity.ProductEntity;
import com.autoparts.productservice.repositories.IProductRepository;
import com.autoparts.productservice.services.api.ICarBrandService;
import com.autoparts.productservice.services.api.ICategoryService;
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

    public ProductService(IProductRepository repository,
                          ICategoryService categoryService,
                          ICarBrandService brandService) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.brandService = brandService;
    }

    @Override
    public ProductDTO find(UUID uuid) {
        ProductEntity productEntity = repository.findById(uuid).orElseThrow(() ->
                new ProductNotFoundException("There is no product with this id : " + uuid));
        return ProductMapper.convertProductEntityToDTO(productEntity);
    }

    @Override
    public Page<ProductDTO> getPage(Pageable pageable) {
        return repository.findAll(pageable).map(ProductMapper::convertProductEntityToDTO);
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
        ProductEntity existProduct = repository.findByTitleAndCategoryAndBrandAndDescriptionAndManufacturerAndPrice(
                product.getTitle(), category,
                brand, product.getDescription(),
                product.getManufacturer(), product.getPrice()
        ).orElse(null);
        if(existProduct!=null)
            throw new ResourceAlreadyExist("Product with this parameters already exist, with id "+existProduct.getId());
        ProductEntity entity = ProductMapper.convertProductDTOToEntity(product);
        entity.setCategory(category);
        entity.setBrand(brand);
        repository.save(entity);
    }

    @Override
    public void increaseAmount(UUID id, Integer amount) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product with id:"+id+" not found"));
        entity.setAmount(entity.getAmount()+amount);
        repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product with id:"+id+" not found"));
        repository.delete(entity);
    }
}
