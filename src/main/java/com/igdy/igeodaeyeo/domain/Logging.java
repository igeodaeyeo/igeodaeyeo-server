package com.igdy.igeodaeyeo.domain;

import com.igdy.igeodaeyeo.global.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class Logging extends BaseEntity {

    private String className; // 발생 위치
    private String msg ; // 로그 내용
    private String code ; // 로그 코드?
}
