package com.igdy.igeodaeyeo.domain.chatting.dto;

import java.time.LocalDateTime;

public record ChatMessageDto(
        Long id,
        Long chatRoomId,
        Long senderId,
        String sender,
        String message,
        LocalDateTime createdAt
) {
}
