package com.igdy.igeodaeyeo.domain.user.exception;

import com.igdy.igeodaeyeo.global.exception.CustomException;
import com.igdy.igeodaeyeo.global.exception.ErrorCode;

public class UserException extends CustomException {

    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
