package com.ecommerce.ElasticSearch.services;

import com.ecommerce.ElasticSearch.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> searchProduct(String query);
//    List<Product> getProductsByCategory(Long categoryId);
}
