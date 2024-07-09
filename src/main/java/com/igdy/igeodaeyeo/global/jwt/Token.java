package com.igdy.igeodaeyeo.global.jwt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "refresh_token")
//@RedisHash(value = "refresh_token", timeToLive = 1000 * 60 * 60L * 24 * 30)
public class Token {

    @Id
    private String id;

    private String accessToken;

    private String refreshToken;

    @Builder
    public Token(String id, String accessToken, String refreshToken) {
        this.id = id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public Token updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public void updateAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
