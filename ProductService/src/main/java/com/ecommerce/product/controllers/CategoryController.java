package com.ecommerce.product.controllers;

import com.ecommerce.product.exceptions.CategoryNotFoundException;
import com.ecommerce.product.models.Category;
import com.ecommerce.product.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) throws CategoryNotFoundException {
        return categoryService.getCategory(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }
    @PutMapping
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
