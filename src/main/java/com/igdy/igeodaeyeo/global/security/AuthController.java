package com.igdy.igeodaeyeo.global.security;

import com.igdy.igeodaeyeo.global.entity.ApiResponse;
import com.igdy.igeodaeyeo.global.jwt.TokenResponse;
import com.igdy.igeodaeyeo.global.jwt.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final TokenService tokenService;

    @GetMapping("/success")
    public ResponseEntity<ApiResponse<TokenResponse>> success(HttpServletRequest request) {
        // get parameter code accessToken
        String accessToken = request.getParameter("accessToken");

        TokenResponse tokenResponse = TokenResponse.builder()
                .accessToken(accessToken)
                .build();

        ApiResponse<TokenResponse> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "로그인 성공",
                tokenResponse
        );

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(@AuthenticationPrincipal UserDetails userDetails) {
        tokenService.deleteRefreshToken(userDetails.getUsername());

        ApiResponse<Void> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                "로그아웃 성공",
                null
        );

        return ResponseEntity.ok(apiResponse);
    }
}
