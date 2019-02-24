package com.bsuir.service.impl;

import com.bsuir.dto.CategoryDto;
import com.bsuir.entity.Category;
import com.bsuir.repository.CategoryRepository;
import com.bsuir.service.CategoryService;
import com.bsuir.service.util.CategoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class of category service that allows you to work with a category and implements CategoryService.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Service
@Transactional
public class DefaultCategoryService implements CategoryService {
    /**
     * Field of Category Repository.
     */
    private final CategoryRepository categoryRepository;

    private final CategoryConverter converter;

    /**
     * Constructor that accepts a object CategoryRepository class.
     *
     * @param categoryRepository object of CategoryRepository class
     */
    @Autowired
    public DefaultCategoryService(CategoryRepository categoryRepository, CategoryConverter converter) {
        this.categoryRepository = categoryRepository;
        this.converter = converter;
    }

    /**
     * Method that save Category in database.
     *
     * @param categoryDto object that needs to save
     * @return saved object of Category class
     */
    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = converter.toCategory(categoryDto);
        Category createdCategory = categoryRepository.save(category);

        return converter.toCategoryDto(createdCategory);
    }

    /**
     * Method that save List of Category objects in database.
     *
     * @param categoriesDto data transfer objects
     * @return created list of objects of Category class
     */
    @Override
    public List<CategoryDto> createAll(List<CategoryDto> categoriesDto) {
        List<Category> categories = converter.toCategories(categoriesDto);
        Iterable<Category> saveCategories = categoryRepository.saveAll(categories);
        List<Category> createdCategories = new ArrayList<>();
        for (Category category : saveCategories) {
            createdCategories.add(category);
        }
        return converter.toCategoriesDto(createdCategories);
    }

    /**
     * Method that finds an object in database.
     *
     * @param id Long of the object to be found
     * @return founded object or NullPointerException
     */
    @Override
    public CategoryDto findById(UUID id) {
        return converter.toCategoryDto(categoryRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    /**
     * Method that finds all objects in database.
     *
     * @return founded objects
     */
    @Override
    public List<CategoryDto> findAll() {
        Iterable<Category> saveCategories = categoryRepository.findAll();
        List<Category> createdCategories = new ArrayList<>();
        for (Category category : saveCategories) {
            createdCategories.add(category);
        }
        return converter.toCategoriesDto(createdCategories);
    }

    /**
     * Method that save updated object.
     *
     * @param categoryDto updated category that needs to save
     * @return updated and saved category
     */
    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return create(categoryDto);
    }

    /**
     * Method that delete object.
     *
     * @param id object that needs to delete
     */
    @Override
    public void delete(UUID id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(e.getMessage());
        }

    }
}
