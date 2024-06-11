package com.igdy.igeodaeyeo.domain.user.entity;

import com.igdy.igeodaeyeo.global.security.OAuthProvider;
import com.igdy.igeodaeyeo.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
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
//    private String email;
    private OAuthProvider oAuthProvider;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User(String email, String nickname, OAuthProvider oAuthProvider) {
        this.loginId = email;
        this.nickname = nickname;
        this.oAuthProvider = oAuthProvider;
    }
}
