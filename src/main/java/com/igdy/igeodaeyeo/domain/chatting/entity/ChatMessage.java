package com.igdy.igeodaeyeo.domain.chatting.entity;

import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class ChatMessage extends BaseEntity {

    private int chatRoomId; // chat_room table id
    private int writerId; // user table id
    private boolean isRead; // 읽음 여부
    private int contents; // 내용
    private int msgType; // 메시지
}
