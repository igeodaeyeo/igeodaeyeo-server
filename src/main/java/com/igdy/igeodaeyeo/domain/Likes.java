package com.igdy.igeodaeyeo.domain;

import com.igdy.igeodaeyeo.global.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 좋아요, 조회수 테이블
 */
@Entity
@NoArgsConstructor
@SuperBuilder
public class Likes extends BaseEntity {

    private int productId; // 좋아요 받은 상품 id / product table id
    private int userId; // 좋아요 보낸 사람, 조회한 사람
    private int dataType; // 데이터 종류 [1] 좋아요 [2] 조회수
}
