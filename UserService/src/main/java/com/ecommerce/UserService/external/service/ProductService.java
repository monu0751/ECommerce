package com.ecommerce.UserService.external.service;

import com.ecommerce.UserService.external.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PRODUCT-SERVICE")
public interface ProductService {
    @GetMapping("/api/v1/products/{id}")
    public Product getProductById(@PathVariable Long id);
}
