package com.igdy.igeodaeyeo.domain.chatting.repository;

import com.igdy.igeodaeyeo.domain.chatting.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatRoomId(Long chatRoomId); // 채팅방 ID로 메시지 조회

}
