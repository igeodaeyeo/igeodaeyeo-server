package com.igdy.igeodaeyeo.domain.chatting.entity;

import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class ChatRoom extends BaseEntity {

    private Long productId; // product table id
    private Long borrowerId; // 빌리는이 / user table id
    private String borrowerName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "lastChatMesgId")
    private ChatMessage lastChatMesg;

}
