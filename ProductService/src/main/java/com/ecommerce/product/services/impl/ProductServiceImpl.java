package com.ecommerce.product.services.impl;

import com.ecommerce.product.dto.request.ProductRequestDTO;
import com.ecommerce.product.dto.response.ProductResponseDTO;
import com.ecommerce.product.exceptions.ProductNotFoundException;
import com.ecommerce.product.models.Product;
import com.ecommerce.product.repos.ProductRepo;
import com.ecommerce.product.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = Product.builder()
                .name(productRequestDTO.getName())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .categoryId(productRequestDTO.getCategoryId())
                .build();
        product = productRepo.save(product);
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryId(product.getCategoryId())
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
                .categoryId(product.getCategoryId())
                .build();
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) throws ProductNotFoundException {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setCategoryId(productRequestDTO.getCategoryId());
        product = productRepo.save(product);
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryId(product.getCategoryId())
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
                .categoryId(product.getCategoryId())
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
                .categoryId(product.getCategoryId())
                .build()).toList();
    }
}
