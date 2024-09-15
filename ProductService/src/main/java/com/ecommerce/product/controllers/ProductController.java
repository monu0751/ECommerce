package com.ecommerce.product.controllers;

import com.ecommerce.product.dto.request.ProductRequestDTO;
import com.ecommerce.product.dto.response.ProductResponseDTO;
import com.ecommerce.product.exceptions.ProductNotFoundException;
import com.ecommerce.product.models.Product;
import com.ecommerce.product.services.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping()
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return productService.createProduct(productRequestDTO);
    }
    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }
    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) throws ProductNotFoundException {
        return productService.updateProduct(id, productRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        productService.deleteProduct(id);
    }

    @GetMapping("/search/{name}")
    public List<ProductResponseDTO> searchProduct(@PathVariable String name) throws ProductNotFoundException {
        return productService.searchProduct(name);
    }
    @GetMapping("/category/{categoryId}")
    public List<ProductResponseDTO> getAllProductsByCategory(@PathVariable Long categoryId) {
        return productService.getAllProductsByCategory(categoryId);
    }

    @GetMapping("/most-rated")
    public List<Product> getMostRatedProducts() {
        return productService.getMostRatedProducts();
    }
}
