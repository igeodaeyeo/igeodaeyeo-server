package com.igdy.igeodaeyeo.global.security;

import com.igdy.igeodaeyeo.global.exception.CustomException;
import com.igdy.igeodaeyeo.global.exception.ErrorCode;

public class AuthException extends CustomException {

    public AuthException(ErrorCode errorCode) {
        super(errorCode);
    }
}
