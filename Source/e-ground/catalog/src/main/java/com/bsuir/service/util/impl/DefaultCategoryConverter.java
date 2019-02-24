package com.bsuir.service.util.impl;

import com.bsuir.dto.CategoryDto;
import com.bsuir.entity.Category;
import com.bsuir.service.util.CategoryConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultCategoryConverter implements CategoryConverter {
    @Override
    public Category toCategory(CategoryDto categoryDto) {
        Category category = new Category();
        if (categoryDto != null) {
            category.setName(categoryDto.getName());
            category.setId(categoryDto.getId());
        }
        return category;
    }

    @Override
    public CategoryDto toCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        if (category != null) {
            categoryDto.setId(category.getId());
            categoryDto.setName(category.getName());
        }
        return categoryDto;
    }


    @Override
    public List<Category> toCategories(List<CategoryDto> categoriesDto) {
        List<Category> categories = new ArrayList<>();
        categoriesDto.forEach(categoryDto -> categories.add(toCategory(categoryDto)));
        return categories;
    }

    @Override
    public List<CategoryDto> toCategoriesDto(List<Category> categories) {
        List<CategoryDto> categoriesDto = new ArrayList<>();
        categories.forEach(category -> categoriesDto.add(toCategoryDto(category)));
        return categoriesDto;
    }
}
