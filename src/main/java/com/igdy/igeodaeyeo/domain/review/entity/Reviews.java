package com.igdy.igeodaeyeo.domain.review.entity;

import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class Reviews extends BaseEntity {

    private int receiverId; // 리뷰 대상자 id / user table id
    private int writerId; // 리뷰 작성자 id / user table id
    private int productId; // product table id
    private String message; // 리뷰 내용
    private int reviewType; // 리뷰 종류
    private int reviewPoint; // 리뷰 점수
}
