package com.igdy.igeodaeyeo.domain.category.dto;

import com.igdy.igeodaeyeo.domain.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    private Long id;
    private Long depthId;
    private String depthName;

    public static CategoryResponse of(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .depthId(category.getDepthId())
                .depthName(category.getDepthName())
                .build();
    }
}
