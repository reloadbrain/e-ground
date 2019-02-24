package com.bsuir.service;

import com.bsuir.dto.CategoryDto;

import java.util.List;
import java.util.UUID;

/**
 * Interface of category service. Contains CRUD methods.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
public interface CategoryService {
    CategoryDto create(CategoryDto categoryDto);

    List<CategoryDto> createAll(List<CategoryDto> categoriesDto);

    CategoryDto findById(UUID id);

    List<CategoryDto> findAll();

    CategoryDto update(CategoryDto CategoryDto);

    void delete(UUID id);
}
