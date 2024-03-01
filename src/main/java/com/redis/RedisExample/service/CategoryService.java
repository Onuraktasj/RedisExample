package com.redis.RedisExample.service;

import com.redis.RedisExample.dto.entitiy.CategoryDto;
import com.redis.RedisExample.dto.request.CreateCategoryRequest;
import com.redis.RedisExample.dto.response.CreateCategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    public CreateCategoryResponse createCategory(CreateCategoryRequest createCategoryRequest);

    public List<CategoryDto> getAllCategories();

    public CategoryDto getCategory(UUID id);


}
