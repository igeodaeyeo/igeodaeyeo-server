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
public class SearchRecords extends BaseEntity {

    private int userId; // user table id
    private int searchWord; // 검색어
    private int stat; // 노출, 삭제 여부
    private int cnt; // 검색 횟수
}
