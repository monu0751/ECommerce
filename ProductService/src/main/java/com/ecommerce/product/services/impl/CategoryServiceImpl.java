package com.ecommerce.product.services.impl;

import com.ecommerce.product.exceptions.CategoryNotFoundException;
import com.ecommerce.product.models.Category;
import com.ecommerce.product.repos.CategoryRepo;
import com.ecommerce.product.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category getCategory(Long id) throws CategoryNotFoundException {

        return categoryRepo.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
}
