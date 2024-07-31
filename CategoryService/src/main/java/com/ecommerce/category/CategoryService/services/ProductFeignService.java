package com.ecommerce.category.CategoryService.services;

import com.ecommerce.category.CategoryService.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8081", name = "product-service")
@FeignClient(name = "product-service")
public interface ProductFeignService {
    @GetMapping("/api/v1/products/category/{categoryId}")
    List<Product> getAllProductsByCategoryId(@PathVariable Long categoryId);
}
