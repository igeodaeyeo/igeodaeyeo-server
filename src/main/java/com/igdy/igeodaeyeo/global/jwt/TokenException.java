package com.igdy.igeodaeyeo.global.jwt;

import com.igdy.igeodaeyeo.global.exception.CustomException;
import com.igdy.igeodaeyeo.global.exception.ErrorCode;

public class TokenException extends CustomException {

    public TokenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
