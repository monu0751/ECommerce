package com.ecommerce.ElasticSearch.controllers;

import com.ecommerce.ElasticSearch.dto.request.SaveCategoryRequestDTO;
import com.ecommerce.ElasticSearch.models.Category;
import com.ecommerce.ElasticSearch.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public Category getCategory(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        return categoryService.getCategoryById(uuid);
    }

    @GetMapping("/search")
    public List<Category> searchCategory(@RequestParam(name="query", required = true) String query) {
        return categoryService.searchCategory(query);
    }

    @PostMapping
    public Category createCategory(@RequestBody SaveCategoryRequestDTO category) {
        return categoryService.saveCategory(category);
    }
    @PutMapping
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        categoryService.deleteCategory(uuid);
    }
}
