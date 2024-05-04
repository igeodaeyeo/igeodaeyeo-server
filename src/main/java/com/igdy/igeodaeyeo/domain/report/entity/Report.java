package com.igdy.igeodaeyeo.domain.report.entity;

import com.igdy.igeodaeyeo.global.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class Report extends BaseEntity {

    private int targetUserId; // 신고 대상이 되는 유저 / user table id
    private int targetId; // 신고 대상이 되는 대상 (게시글, 댓글 등) / (any) table id
    private int reportType; // !! 데이터 타입 고민 // 신고 종류
    private int userId; // !! 필드명 변경 필요 // 신고자 id / user table id
    private int reason; // 신고 사유
    private int result; // 신고 처리 결과이자 단계 접수 -> 처리중 -> 완료(조치사항)
}
