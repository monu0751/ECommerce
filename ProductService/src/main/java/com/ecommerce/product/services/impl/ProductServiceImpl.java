package com.ecommerce.product.services.impl;

import com.ecommerce.product.dto.request.ProductRequestDTO;
import com.ecommerce.product.dto.response.ProductResponseDTO;
import com.ecommerce.product.exceptions.ProductNotFoundException;
import com.ecommerce.product.external.service.RedisService;
import com.ecommerce.product.models.Product;
import com.ecommerce.product.repos.CategoryRepo;
import com.ecommerce.product.repos.ProductRepo;
import com.ecommerce.product.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final RedisService redisService;

    public ProductServiceImpl(ProductRepo productRepo, CategoryRepo categoryRepo, RedisService redisService) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.redisService = redisService;
    }


    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = Product.builder()
                .name(productRequestDTO.getName())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .category(categoryRepo.findById(
                        productRequestDTO.getCategoryId()).orElse(null))
                .build();
        product = productRepo.save(product);
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
    }

    @Override
    public ProductResponseDTO getProductById(Long id) throws ProductNotFoundException {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) throws ProductNotFoundException {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setCategory(categoryRepo
                .findById(productRequestDTO.getCategoryId()).orElse(null));
        product = productRepo.save(product);
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        productRepo.delete(product);
    }


    @Override
    public List<ProductResponseDTO> searchProduct(String name) {
        List<Product> products = productRepo.findByName(name);
        return products.stream().map(product -> ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .build()).toList();
    }

    @Override
    public List<ProductResponseDTO> getAllProductsByCategory(Long categoryId) {
        List<Product> products = productRepo.findByCategoryId(categoryId);
        return products.stream().map(product -> ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .build()).toList();
    }

    @Override
    public List<Product> getMostRatedProducts() {
        return redisService.getMostRatedProducts("high_rated_products");
    }
}
