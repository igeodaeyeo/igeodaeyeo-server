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
    ILLEGAL_REGISTRATION_ID(NOT_ACCEPTABLE, "Illegal registration ID"),

    // user
    NICKNAME_ALREADY_USED(BAD_REQUEST, "이미 사용중인 닉네임입니다."),
    USER_NOT_FOUND(NOT_FOUND, "회원을 찾을 수 없습니다."),

    // category
    CATEGORY_NOT_FOUND(NOT_FOUND, "카테고리를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
