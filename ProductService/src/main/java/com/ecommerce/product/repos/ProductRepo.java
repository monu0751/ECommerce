package com.ecommerce.product.repos;

import com.ecommerce.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByCategoryId(Long categoryId);
}
