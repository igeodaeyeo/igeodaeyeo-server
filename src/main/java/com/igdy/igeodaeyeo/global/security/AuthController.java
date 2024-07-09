package com.igdy.igeodaeyeo.global.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    @GetMapping("/success")
    public ResponseEntity<String> success(HttpServletRequest request) {
        // get parameter code accessToken
        String accessToken = request.getParameter("accessToken");
        return ResponseEntity.ok(accessToken);
    }
}
