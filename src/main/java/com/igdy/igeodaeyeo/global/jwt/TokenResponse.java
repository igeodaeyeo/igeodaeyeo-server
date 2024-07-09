package com.igdy.igeodaeyeo.global.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenResponse {

    @JsonProperty("accessToken")
    private String accessToken;
}
