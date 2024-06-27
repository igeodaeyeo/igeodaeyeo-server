package com.igdy.igeodaeyeo.global.security;

import com.igdy.igeodaeyeo.domain.user.entity.Role;
import com.igdy.igeodaeyeo.domain.user.entity.User;

import java.util.Map;

public class KakaoUserInfo implements OAuth2UserInfo{

    private Map<String, Object> attributes;

    public KakaoUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getEmail() {
        return (String) ((Map) attributes.get("kakao_account")).get("email");
    }

    @Override
    public String getNickname() {
        return (String) ((Map) attributes.get("properties")).get("nickname");
    }

    @Override
    public User toEntity() {
        System.out.println(getEmail());

        return User.builder()
                .loginId(getEmail())
                .nickname(getNickname())
                .oAuthProvider(OAuthProvider.KAKAO)
                .role(Role.USER)
                .build();
    }


}
