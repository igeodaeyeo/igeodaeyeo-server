package com.igdy.igeodaeyeo.domain.chatting.entity;

import com.igdy.igeodaeyeo.global.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class Chatroom extends BaseEntity {

    private int productId; // product table id
    private int lenderId; // 빌려주는이 / user table id
    private int borrowerId; // 빌리는이 / user table id
}
