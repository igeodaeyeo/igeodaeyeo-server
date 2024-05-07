package com.igdy.igeodaeyeo.domain.product.entity;

import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 좋아요, 조회수 테이블 - 2024-05-04 ~
 */
@Entity
@NoArgsConstructor
@SuperBuilder
public class ProductDetail extends BaseEntity {

    private int productId; // 좋아요 받은 상품 id / product table id
    private int userId; // 좋아요 보낸 사람, 조회한 사람
    private int dataType; // 데이터 종류 [1] 좋아요 [2] 조회수
}
