package com.igdy.igeodaeyeo.domain.user.entity;

import com.igdy.igeodaeyeo.global.BaseEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class UserDetail extends BaseEntity {

//    @Column(unique = true) ?
    private int userId; // user table id
}
