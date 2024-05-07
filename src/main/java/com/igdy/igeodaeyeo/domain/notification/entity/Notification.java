package com.igdy.igeodaeyeo.domain.notification.entity;

import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class Notification extends BaseEntity {

    private int senderId; // 알림 전송자 / user table id
    private int receiverId; // 알림 수신자 / user table id
    private int notificationType; // 알림 타입
    private String title; // 제목
    private String contents; // 내용
    private boolean notificationStat; // 상태 구분값 [0] 안읽음 [1] 읽음 ... ... [99] 삭제 ... ...
}
