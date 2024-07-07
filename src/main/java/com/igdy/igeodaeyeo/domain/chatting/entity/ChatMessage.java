package com.igdy.igeodaeyeo.domain.chatting.entity;

import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ChatMessage extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoomId; // chat_room table id
    private Long senderId; // 메시지 보낸 사용자 ID
    private boolean isRead; // 읽음 여부
    private String sender; // 메시지 보낸 사용자 닉네임
    private String message; // 내용
    private int msgType; // 메시지
}
