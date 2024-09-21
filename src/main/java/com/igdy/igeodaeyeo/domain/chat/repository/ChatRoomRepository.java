package com.igdy.igeodaeyeo.domain.chatting.repository;

import com.igdy.igeodaeyeo.domain.chatting.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    List<ChatRoom> findByBorrowerName(Long borrowerName);

}
