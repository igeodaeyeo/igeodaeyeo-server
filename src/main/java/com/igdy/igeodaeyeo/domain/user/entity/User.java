package com.igdy.igeodaeyeo.domain.user.entity;

import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
public class User extends BaseEntity {

    @Column(unique = true)
    private String loginId;
    private String nickname;
    private String realName;
    private String phoneNumber;
    private String profileImageUrl;
    private String birth;
    private String sex;
}
