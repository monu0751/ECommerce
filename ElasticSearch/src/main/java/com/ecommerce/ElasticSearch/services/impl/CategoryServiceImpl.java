package com.ecommerce.ElasticSearch.services.impl;

import com.ecommerce.ElasticSearch.dto.request.SaveCategoryRequestDTO;
import com.ecommerce.ElasticSearch.models.Category;
import com.ecommerce.ElasticSearch.repos.CategoryRepo;
import com.ecommerce.ElasticSearch.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public List<Category> getAllCategories() {
        Iterable<Category> all = categoryRepo.findAll();
        return (List<Category>) all;
    }

    @Override
    public Category getCategoryById(UUID id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Category saveCategory(SaveCategoryRequestDTO dtoCategory) {
        Category category = Category.builder()
                .name(dtoCategory.getName())
                .description(dtoCategory.getDescription())
                .categoryId(dtoCategory.getCategoryId())
                .id(UUID.randomUUID())
                .build();
        return categoryRepo.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public List<Category> searchCategory(String query) {
        Iterable<Category> allByName = categoryRepo.searchByNameOrDescription(query);
        return (List<Category>) allByName;
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepo.save(category);
    }
}
