package com.igdy.igeodaeyeo.domain.chatting.service;

import com.igdy.igeodaeyeo.domain.chatting.dto.ChatRoomDto;
import com.igdy.igeodaeyeo.domain.chatting.entity.ChatRoom;
import com.igdy.igeodaeyeo.domain.chatting.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Override
    public ChatRoom createChatRoom(ChatRoomDto chatRoomDto) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setBorrowerName(chatRoomDto.borrowerName());
        return chatRoomRepository.save(chatRoom);
    }

    @Override
    public List<ChatRoom> getChatRoomsByUserId(Long userId) {
        return chatRoomRepository.findByBorrowerName(userId); // 사용자 이름으로 채팅방 조회
    }

}
