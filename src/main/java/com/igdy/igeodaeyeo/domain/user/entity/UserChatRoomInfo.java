package com.igdy.igeodaeyeo.domain.user.entity;

import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class UserChatRoomInfo extends BaseEntity {

    private int userId; // user table id
    private int chatRoomId; // chat_room table id
    private boolean isCurrentEnter; // 현재 채팅방 접속중인지 여부
    private String lastEnterTime; // 채팅방 마지막 입장 시간
    private int chatRoomStat; // 채팅방 상태
    private boolean isAlarm; //  채팅방 알람 여부
}
