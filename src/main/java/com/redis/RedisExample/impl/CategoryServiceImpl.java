package com.redis.RedisExample.impl;

import com.redis.RedisExample.dto.entitiy.CategoryDto;
import com.redis.RedisExample.dto.request.CreateCategoryRequest;
import com.redis.RedisExample.dto.response.CreateCategoryResponse;
import com.redis.RedisExample.entity.Category;
import com.redis.RedisExample.exception.CategoryNotFoundException;
import com.redis.RedisExample.mapper.CategoryMapper;
import com.redis.RedisExample.repository.CategoryRepository;
import com.redis.RedisExample.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public CreateCategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) {

        Category category = categoryRepository.save(CategoryMapper.toEntity(createCategoryRequest));

        CreateCategoryResponse createCategoryResponse = CategoryMapper.toCreateCategoryResponse(category);

        return createCategoryResponse;

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return CategoryMapper.toDtoList(this.categoryRepository.findAll());
    }

    @Override
    @Cacheable(value = "categoryCache", key = "'category_' + #id")
    public CategoryDto getCategory(UUID id) {
        System.out.println("Getting from DB");
        return CategoryMapper.toDto(categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found")));
    }
}
