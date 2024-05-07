package com.igdy.igeodaeyeo.domain.product.entity;

import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class ProductShareInfo extends BaseEntity {

    private int productId; // product table id
    private int lenderId; // 빌려주는이 / user table id
    private int borrowerId; // 빌리는이 / user table id
    private int chatroomId; // chatroom table id
    private String startDate; // 대여 시작 날짜
    private String endDate; // 대여 종료 날짜
    private int provideConsentStep; // !! 필드명 변경 필요 // 상호 정보 제공 동의 여부? 단계?
    private int transactionStep; // !! 필드명 변경 필요 // 거래 단계
    private int finalPrice; // 최종 거래 가격
    private boolean isDelivery; // 택배 거래 여부
    private String signImgUrl; // 타입 정의 필요 // 서명 이미지 url
}
