package com.igdy.igeodaeyeo.global.security;

import com.igdy.igeodaeyeo.domain.user.entity.Role;
import com.igdy.igeodaeyeo.domain.user.entity.User;
import com.igdy.igeodaeyeo.global.utils.KeyGenerator;

import java.util.Map;

public class NaverUserInfo implements OAuth2UserInfo {

    private Map<String, Object> attributes; // -> oauth2User.getAttributes()
    private Map<String, Object> response;

    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.response = (Map<String, Object>) attributes.get("response");
    }

    @Override
    public String getProviderId() {
        return response.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getEmail() {
        return response.get("email").toString();
    }

    @Override
    public String getName() {
        return response.get("name").toString();
    }

    @Override
    public String getNickname() {
        return response.get("nickname").toString();
    }

    @Override
    public User toEntity() {
        return User.builder()
                .loginId(getEmail())
                .nickname(getNickname())
                .realName(getName())
                .oAuthProvider(OAuthProvider.NAVER)
                .role(Role.USER)
                .userKey(KeyGenerator.generateKey())
                .build();
    }

}
