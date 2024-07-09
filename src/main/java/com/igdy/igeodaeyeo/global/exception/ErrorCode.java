package com.igdy.igeodaeyeo.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // auth
    TOKEN_EXPIRED(UNAUTHORIZED, "토큰이 만료되었습니다."),
    INVALID_TOKEN(UNAUTHORIZED, "올바르지 않은 토큰입니다."),
    INVALID_JWT_SIGNATURE(UNAUTHORIZED, "잘못된 JWT 서명입니다."),

    // user
    NICKNAME_ALREADY_USED(BAD_REQUEST, "이미 사용중인 닉네임입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
