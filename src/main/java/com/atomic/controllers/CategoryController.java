package com.atomic.controllers;


import com.atomic.models.Category;
import com.atomic.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            Category category = categoryRepository.getOne(id);
            return ResponseEntity.status(HttpStatus.OK).body(category);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Category with id " + id + " " + "not found");
        }
    }

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity create(@RequestBody Category category) {
        categoryRepository.save(category);

        return ResponseEntity.status(HttpStatus.OK).body("Category successful created with id " + category.getId());
    }

    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity delete(@PathVariable Long categoryId) {
        categoryRepository.deleteById(categoryId);

        return ResponseEntity.status(HttpStatus.OK).body("Category deleted with this id: " + categoryId);
    }
}
