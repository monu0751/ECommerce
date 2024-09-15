package com.ecommerce.ElasticSearch.controllers;

import com.ecommerce.ElasticSearch.models.Product;
import com.ecommerce.ElasticSearch.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private  ProductService productService;
    @PostMapping
    public Product createProduct(@RequestBody Product productRequestDTO) {
        return productService.saveProduct(productRequestDTO);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productRequestDTO) {
        return productService.updateProduct(id, productRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/search/{name}")
    public List<Product> searchProduct(@PathVariable String name) {
        return productService.searchProduct(name);
    }
//    @GetMapping("/category/{categoryId}")
//    public List<Product> getAllProductsByCategory(@PathVariable Long categoryId) {
//        return productService.getProductsByCategory(categoryId);
//    }

}
