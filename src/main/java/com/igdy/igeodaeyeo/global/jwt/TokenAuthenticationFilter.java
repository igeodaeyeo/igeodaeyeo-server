package com.igdy.igeodaeyeo.global.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    // Token에 대한 인증 처리

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private final TokenProvider tokenProvider;

    // 실제 필터링 로직은 doFilterInternal 메서드에 구현
    // 토큰을 검증하고 현재 쓰레드의 SecurityContext에 저장하는 역할
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // request header에서 access token 가져오기
        String accessToken = resolveToken(request);

        // access token 검증
        if (StringUtils.hasText(accessToken) && tokenProvider.validateToken(accessToken)) {
            // 정상 토큰이면 해당 토큰으로 authentication 가져와서 SecurityContext에 저장
            Authentication authentication = tokenProvider.getAuthentication(accessToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // print name, email, nickname
            System.out.println("access token 검증 성공!");
        }
        else {
            // 만료되었을 경우 access token 재발급
            String reissueAccessToken = tokenProvider.reissueAccessToken(accessToken);

            if (StringUtils.hasText(reissueAccessToken)) {
                Authentication authentication = tokenProvider.getAuthentication(reissueAccessToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);

                // 재발급된 access token 다시 전달
                response.setHeader(AUTHORIZATION_HEADER, BEARER_PREFIX + reissueAccessToken);
            }
        }

        filterChain.doFilter(request, response);
    }

    // request header에서 토큰 정보 가져오기
    private String resolveToken(HttpServletRequest request) {
//        System.out.println("resolveToken: " + request.getHeader(AUTHORIZATION_HEADER));
//        System.out.println("request url: " + request.getRequestURL());

        String token = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(token) && token.startsWith(BEARER_PREFIX)) {
            return token.substring(BEARER_PREFIX.length());
        }
        return null;
    }

}
