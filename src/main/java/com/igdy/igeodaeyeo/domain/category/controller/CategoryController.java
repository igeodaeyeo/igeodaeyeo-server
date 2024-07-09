package com.igdy.igeodaeyeo.domain.category.controller;

import com.igdy.igeodaeyeo.domain.category.dto.CategoryRequest;
import com.igdy.igeodaeyeo.domain.category.dto.CategoryResponse;
import com.igdy.igeodaeyeo.domain.category.entity.Category;
import com.igdy.igeodaeyeo.domain.category.service.CategoryService;
import com.igdy.igeodaeyeo.global.entity.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // 모든 카테고리 조회
    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> findAllCategories() {
        List<Category> categories = categoryService.findAllCategories();
        List<CategoryResponse> responseList = categories.stream()
                .map(CategoryResponse::of)
                .toList();

        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK.value(),
                "모든 카테고리 조회 성공",
                responseList
        ));
    }

    // 카테고리 조회
    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResponse>> findCategory(@PathVariable("categoryId") Long categoryId) {
        CategoryResponse categoryResponse = CategoryResponse.of(categoryService.findCategoryById(categoryId));
        ApiResponse<CategoryResponse> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "카테고리 조회 성공",
                categoryResponse
        );

        return ResponseEntity.ok(apiResponse);
    }

    // 카테고리 생성
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createCategory(@RequestBody CategoryRequest categoryRequest) {
        categoryService.createNewCategory(categoryRequest);

        ApiResponse<Void> apiResponse = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                "카테고리 생성 성공",
                null
        );

        return ResponseEntity.ok(apiResponse);
    }

    // 카테고리 수정
    @PutMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<Void>> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody CategoryRequest categoryRequest) {
        categoryService.updateCategory(categoryService.findCategoryById(categoryId), categoryRequest);

        ApiResponse<Void> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "카테고리 수정 성공",
                null
        );

        return ResponseEntity.ok(apiResponse);
    }

    // 카테고리 삭제
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<Void>> removeCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.removeCategory(categoryService.findCategoryById(categoryId));

        ApiResponse<Void> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "카테고리 삭제 성공",
                null
        );

        return ResponseEntity.ok(apiResponse);
    }
}
