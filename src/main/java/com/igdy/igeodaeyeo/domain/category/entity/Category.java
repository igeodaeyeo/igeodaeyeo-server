package com.igdy.igeodaeyeo.domain.category.entity;

import com.igdy.igeodaeyeo.domain.category.dto.CategoryRequest;
import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@NoArgsConstructor
@SuperBuilder
public class Category extends BaseEntity {

    private Long depthId; // 카테고리 고유 번호
    private String depthName; // 카테고리명
    private int depthNum; // 카테고리 단계 번호

    private int depth1Id; // 1단게 카테고리 고유 번호
    private String depth1Name; // 1단게 카테고리명
    private int depth2Id; // 2단게 카테고리 고유 번호
    private String depth2Name; // 2단게 카테고리명
    private int depth3Id; // 3단게 카테고리 고유 번호
    private String depth3Name; // 3단게 카테고리명

    public void updateCategory(CategoryRequest categoryRequest) {
        this.depthId = categoryRequest.getDepthId();
        this.depthName = categoryRequest.getDepthName();
    }

}
