package com.ecommerce.category.CategoryService.repos;

import com.ecommerce.category.CategoryService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
