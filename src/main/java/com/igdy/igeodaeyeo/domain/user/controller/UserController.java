package com.igdy.igeodaeyeo.domain.user.controller;

import com.igdy.igeodaeyeo.domain.user.dto.ChangeNicknameRequest;
import com.igdy.igeodaeyeo.domain.user.entity.Role;
import com.igdy.igeodaeyeo.domain.user.entity.User;
import com.igdy.igeodaeyeo.domain.user.service.UserService;
import com.igdy.igeodaeyeo.global.entity.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 닉네임 설정

    // 로그아웃

    // 닉네임 변경
    @PatchMapping("/change-nickname")
    public ResponseEntity<ApiResponse<Void>> changeNickname(@RequestBody ChangeNicknameRequest changeNicknameRequest, @AuthenticationPrincipal UserDetails userDetails) throws Exception {

        User user = userService.findByEmail(userDetails.getUsername());

        // 닉네임 24시간 이후 변경 가능?

        String nickname = userService.changeNickname(user, changeNicknameRequest.getNewNickname());

        ApiResponse<Void> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "닉네임이 성공적으로 변경되었습니다: " + nickname,
                null
        );

        return ResponseEntity.ok(response);
    }

    // 프로필 이미지 변경
}
