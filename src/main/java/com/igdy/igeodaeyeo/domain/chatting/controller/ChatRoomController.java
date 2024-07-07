package com.igdy.igeodaeyeo.domain.chatting.controller;

import com.igdy.igeodaeyeo.domain.chatting.dto.ChatRoomDto;
import com.igdy.igeodaeyeo.domain.chatting.entity.ChatRoom;
import com.igdy.igeodaeyeo.domain.chatting.service.ChatRoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    // 사용자별 채팅방 생성 API
    @PostMapping("/create")
    public ChatRoom createChatRoom(@RequestBody ChatRoomDto chatRoomDto) {
        return chatRoomService.createChatRoom(chatRoomDto);
    }

    // 채팅방 목록 조회 API (사용자별 채팅방 목록)
    @GetMapping("/rooms/{userId}")
    public List<ChatRoom> getChatRooms(@PathVariable Long userId) {
        return chatRoomService.getChatRoomsByUserId(userId);
    }

}
