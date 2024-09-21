package com.igdy.igeodaeyeo.domain.chatting.service;

import com.igdy.igeodaeyeo.domain.chatting.dto.ChatRoomDto;
import com.igdy.igeodaeyeo.domain.chatting.entity.ChatRoom;

import java.util.List;

public interface ChatRoomService {

    ChatRoom createChatRoom(ChatRoomDto chatRoomDto);

    List<ChatRoom> getChatRoomsByUserId(Long userId);
}
