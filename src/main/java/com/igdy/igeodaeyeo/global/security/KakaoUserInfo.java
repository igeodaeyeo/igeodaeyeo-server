package com.igdy.igeodaeyeo.global.security;

import com.igdy.igeodaeyeo.domain.user.entity.Role;
import com.igdy.igeodaeyeo.domain.user.entity.User;

import java.util.Map;

public class KakaoUserInfo implements OAuth2UserInfo{

    private Map<String, Object> attributes;
    private Map<String, Object> kakaoAccount;
    private Map<String, Object> properties;

    public KakaoUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        this.properties = (Map<String, Object>) attributes.get("properties");
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
    public String getEmail() { return kakaoAccount.get("email").toString(); }

    @Override
    public String getNickname() { return properties.get("nickname").toString(); }

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
