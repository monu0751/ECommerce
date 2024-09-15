package com.ecommerce.ElasticSearch.services.impl;

import com.ecommerce.ElasticSearch.models.Product;
import com.ecommerce.ElasticSearch.repos.ProductRepo;
import com.ecommerce.ElasticSearch.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

//    public ProductServiceImpl(ProductRepo productRepo) {
//        this.productRepo = productRepo;
//    }

    @Override
    public List<Product> getAllProducts() {
        Iterable<Product> all = productRepo.findAll();
        return (List<Product>) all;
    }

    @Override
    public Product getProductById(Long id) {

        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> searchProduct(String query) {
        Iterable<Product> allByName = productRepo.findAllByName(query);
        return (List<Product>) allByName;
    }

//    @Override
//    public List<Product> getProductsByCategory(Long categoryId) {
//        Iterable<Product> byCategoryId = productRepo.findByCategoryId(categoryId);
//        return (List<Product>) byCategoryId;
//    }
}
