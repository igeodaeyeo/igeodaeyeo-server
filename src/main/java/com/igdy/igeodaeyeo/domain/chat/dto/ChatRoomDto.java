package com.igdy.igeodaeyeo.domain.chatting.dto;

public record ChatRoomDto(
        Long roomId,
        // Long productId,
        Long borrowerId, // 빌리는 사람 Id,
        String borrowerName
        ) {
}
