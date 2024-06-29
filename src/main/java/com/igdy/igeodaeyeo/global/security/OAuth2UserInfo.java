package com.igdy.igeodaeyeo.global.security;

import com.igdy.igeodaeyeo.domain.user.entity.User;

public interface OAuth2UserInfo {

    String getProviderId(); // google, naver
    String getProvider(); // google, naver
    String getEmail();
    String getNickname();
    User toEntity();

    // 네이버는 이름을 제공하지만 카카오는 제공하지 않음
    default String getName() {
        return null;
    };
}
