package com.igdy.igeodaeyeo.domain.category.service;

import com.igdy.igeodaeyeo.domain.category.dto.CategoryRequest;
import com.igdy.igeodaeyeo.domain.category.entity.Category;
import com.igdy.igeodaeyeo.domain.category.exception.CategoryException;
import com.igdy.igeodaeyeo.domain.category.repository.CategoryRepository;
import com.igdy.igeodaeyeo.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryException(ErrorCode.CATEGORY_NOT_FOUND));
    }

    @Transactional
    public void createNewCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequest.toEntity();
        categoryRepository.save(category);
    }

    public void updateCategory(Category category, CategoryRequest categoryRequest) {
        category.updateCategory(categoryRequest);
        categoryRepository.save(category);
    }

    public void removeCategory(Category category) {
        categoryRepository.delete(category);
    }
}
