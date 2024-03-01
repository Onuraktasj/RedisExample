package com.redis.RedisExample.mapper;

import com.redis.RedisExample.dto.entitiy.CategoryDto;
import com.redis.RedisExample.dto.request.CreateCategoryRequest;
import com.redis.RedisExample.dto.response.CreateCategoryResponse;
import com.redis.RedisExample.entity.Category;
import com.redis.RedisExample.exception.CategoryNotFoundException;

import java.util.List;
import java.util.Objects;


public class CategoryMapper {

    public static CategoryDto toDto(Category category){
        if (Objects.isNull(category)) {
            return null;
        }


        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        if (Objects.isNull(categoryDto)) {
            return null;
        }

        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
    }

    public static Category toEntity(CreateCategoryRequest createCategoryRequest){
        if (Objects.isNull(createCategoryRequest)) {
            return null;
        }

        return Category.builder()
                .name(createCategoryRequest.getName())
                .build();
    }

    public static CreateCategoryResponse toCreateCategoryResponse(Category category){
        if (Objects.isNull(category)) {
            return null;
        }

        return CreateCategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static List<CategoryDto> toDtoList(List<Category> categories){
        return categories.stream().parallel()
                .map(CategoryMapper::toDto)
                .toList();
    }
}
