package com.igdy.igeodaeyeo.domain.category.exception;

import com.igdy.igeodaeyeo.global.exception.CustomException;
import com.igdy.igeodaeyeo.global.exception.ErrorCode;

public class CategoryException extends CustomException {

    public CategoryException(ErrorCode errorCode) { super(errorCode); }
}
