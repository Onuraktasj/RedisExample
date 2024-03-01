package com.redis.RedisExample.controller;

import com.redis.RedisExample.dto.entitiy.CategoryDto;
import com.redis.RedisExample.dto.request.CreateCategoryRequest;
import com.redis.RedisExample.dto.response.CreateCategoryResponse;
import com.redis.RedisExample.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CreateCategoryResponse> createCategory(@RequestBody CreateCategoryRequest createCategoryRequest){
        return ResponseEntity.ok(categoryService.createCategory(createCategoryRequest));
    }

    @GetMapping(value = "getAll")
    public ResponseEntity<List<CategoryDto>> getCategory(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

}
