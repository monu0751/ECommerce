package com.ecommerce.category.CategoryService.services;

import com.ecommerce.category.CategoryService.models.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategory(Long id);
    List<Category> getAllCategories();
}
