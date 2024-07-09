package com.igdy.igeodaeyeo.global.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private int statusCode;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
