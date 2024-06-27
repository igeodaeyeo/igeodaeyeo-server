package com.igdy.igeodaeyeo.global.security;

import com.igdy.igeodaeyeo.domain.user.entity.Role;
import com.igdy.igeodaeyeo.domain.user.entity.User;
import com.igdy.igeodaeyeo.global.security.OAuthProvider;

import java.util.Map;

public class NaverUserInfo implements OAuth2UserInfo {

    private Map<String, Object> attributes; // -> oauth2User.getAttributes()

    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return (String) ((Map) attributes.get("response")).get("id");
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getEmail() {
        return (String) ((Map) attributes.get("response")).get("email");
    }

    @Override
    public String getName() {
        return (String) ((Map) attributes.get("response")).get("name");
    }

    @Override
    public String getNickname() {
        return (String) ((Map) attributes.get("response")).get("nickname");
    }

    @Override
    public User toEntity() {
        System.out.println(getEmail());

        return User.builder()
                .loginId(getEmail())
                .nickname(getNickname())
                .realName(getName())
                .oAuthProvider(OAuthProvider.NAVER)
                .role(Role.USER)
                .build();
    }

}
