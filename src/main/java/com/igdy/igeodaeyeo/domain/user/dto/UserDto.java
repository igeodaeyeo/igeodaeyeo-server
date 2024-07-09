package com.igdy.igeodaeyeo.domain.user.dto;

import com.igdy.igeodaeyeo.domain.user.entity.User;
import com.igdy.igeodaeyeo.global.security.OAuthProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String email;
    private String nickname;
    private String realName;
    private OAuthProvider oAuthProvider;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .email(user.getLoginId())
                .nickname(user.getNickname())
                .realName(user.getRealName())
                .oAuthProvider(user.getOAuthProvider())
                .build();
    }
}
