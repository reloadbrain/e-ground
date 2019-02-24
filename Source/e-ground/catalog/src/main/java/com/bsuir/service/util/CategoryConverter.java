package com.bsuir.service.util;

import com.bsuir.dto.CategoryDto;
import com.bsuir.entity.Category;

import java.util.List;

public interface CategoryConverter {
    Category toCategory(CategoryDto categoryDto);

    CategoryDto toCategoryDto(Category category);

    List<Category> toCategories(List<CategoryDto> categoriesDto);

    List<CategoryDto> toCategoriesDto(List<Category> categories);
}
