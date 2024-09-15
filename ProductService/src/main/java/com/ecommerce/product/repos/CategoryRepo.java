package com.ecommerce.product.repos;

import com.ecommerce.product.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long>{
}
