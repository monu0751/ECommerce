package com.ecommerce.ElasticSearch.services;

import com.ecommerce.ElasticSearch.dto.request.SaveCategoryRequestDTO;
import com.ecommerce.ElasticSearch.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(UUID id);
    Category saveCategory(SaveCategoryRequestDTO category);
    void deleteCategory(UUID id);
    List<Category> searchCategory(String query);
    Category updateCategory(Category category);

}
