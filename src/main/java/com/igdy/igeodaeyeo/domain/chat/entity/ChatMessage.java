package com.igdy.igeodaeyeo.domain.chatting.entity;

import com.igdy.igeodaeyeo.domain.user.entity.User;
import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@SuperBuilder
public class ChatMessage extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoomId; // chat_room table id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User senderId; // 메시지 보낸 사용자 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiverId; // 메시지 받은 사용자 ID

    private boolean isRead; // 읽음 여부
    private String message; // 내용
    private int msgType; // 메시지
    private LocalDateTime sendTime; // 메시지 생성 시간
}

