package com.igdy.igeodaeyeo.global.security;

import com.igdy.igeodaeyeo.domain.user.entity.User;

public interface OAuth2UserInfo {

    String getProviderId(); // google, naver
    String getGetProvider(); // google, naver
    String getEmail();
    String getName();
    String getNickname();
    User toEntity();
}
