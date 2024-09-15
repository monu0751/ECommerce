package com.ecommerce.product.services;

import com.ecommerce.product.exceptions.CategoryNotFoundException;
import com.ecommerce.product.models.Category;

import java.util.List;

public interface CategoryService {
    public Category createCategory(Category category);
    public Category updateCategory(Category category);
    public Category getCategory(Long id) throws CategoryNotFoundException;
    public List<Category> getAllCategories();
    public void deleteCategory(Long id);
}
