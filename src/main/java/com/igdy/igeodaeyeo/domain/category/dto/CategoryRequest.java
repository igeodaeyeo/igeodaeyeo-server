package com.igdy.igeodaeyeo.domain.category.dto;

import com.igdy.igeodaeyeo.domain.category.entity.Category;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryRequest {

    private Long depthId;
    private String depthName;

    public Category toEntity() {
        return Category.builder()
                .depthId(depthId)
                .depthName(depthName)
                .build();
    }

}
