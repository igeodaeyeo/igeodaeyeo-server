package com.igdy.igeodaeyeo.domain.region.entity;

import com.igdy.igeodaeyeo.global.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class Region extends BaseEntity {

    private int depthId; // 지역 고유 번호
    private String depthName; // 지역명
    private int depthNum; // 지역 단계 번호

    private int depth1Id; // 1단게 지역 고유 번호
    private String depth1Name; // 1단게 지역명
    private int depth2Id; // 2단게 지역 고유 번호
    private String depth2Name; // 2단게 지역명
    private int depth3Id; // 3단게 지역 고유 번호
    private String depth3Name; // 3단게 지역명
    private int depth4Id; // !! 불필요시 삭제 // 4단게 지역 고유 번호
    private String depth4Name; // !! 불필요시 삭제 // 4단게 지역명
    private double longitude; // 경도
    private double latitude; // 위도
}
