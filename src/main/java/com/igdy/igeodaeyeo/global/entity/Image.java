package com.igdy.igeodaeyeo.global.entity;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class Image extends BaseEntity {

    private int productId; // product table id
    private String imgOrgNm; // 이미지 원본 이름
    private String imgPath; // 이미지 경로
    private int imgSize; // 이미지 사이즈
    private String extension; // 확장자
}
