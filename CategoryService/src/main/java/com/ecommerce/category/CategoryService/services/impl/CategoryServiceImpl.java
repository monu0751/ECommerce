package com.ecommerce.category.CategoryService.services.impl;

import com.ecommerce.category.CategoryService.models.Category;
import com.ecommerce.category.CategoryService.repos.CategoryRepo;
import com.ecommerce.category.CategoryService.services.CategoryService;
import com.ecommerce.category.CategoryService.services.ProductFeignService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepo categoryRepo;
    private final ProductFeignService productFeignService;

    public CategoryServiceImpl(CategoryRepo categoryRepo, ProductFeignService productFeignService) {
        this.categoryRepo = categoryRepo;
        this.productFeignService = productFeignService;
    }

    @Override
    public Category createCategory(Category category) {
       return this.categoryRepo.save(category);
    }

    @Override
    public Category getCategory(Long id) {
        Category category = this.categoryRepo.findById(id).orElse(null);
        if(category == null) {
            return null;
        }
        category.setProducts(this.productFeignService.getAllProductsByCategoryId(id));
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        return categories.stream().map(category -> {
            category.setProducts(this.productFeignService.getAllProductsByCategoryId(category.getId()));
            return category;
        }).toList();
    }
}
