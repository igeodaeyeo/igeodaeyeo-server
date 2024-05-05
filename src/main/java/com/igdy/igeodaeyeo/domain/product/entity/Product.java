package com.igdy.igeodaeyeo.domain.product.entity;

import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class Product extends BaseEntity {

    private int writerId; // 작성자 아이디 / user table id
    private String productName; // 물품 이름
    private int price; // 가격
    private String description; // 내용
    private String categoryNumber; // 카테고리 번호
    private boolean deliveryAvailability; // 택배 가능 여부
    private boolean purchaseAvailability; // 구매 가능 여부
    private int purchaseStat; // 판매 상태 구분값
    private String dateUnit; // !! 타입 미정  // 날짜 단위
}
