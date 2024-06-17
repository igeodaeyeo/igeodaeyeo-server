package com.igdy.igeodaeyeo.global.config;

import com.igdy.igeodaeyeo.global.jwt.JwtAccessDeniedHandler;
import com.igdy.igeodaeyeo.global.jwt.JwtAuthenticationEntryPoint;
import com.igdy.igeodaeyeo.global.jwt.TokenAuthenticationFilter;
import com.igdy.igeodaeyeo.global.jwt.TokenExceptionFilter;
import com.igdy.igeodaeyeo.global.security.CustomOAuth2UserService;
import com.igdy.igeodaeyeo.global.security.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService oAuth2UserService;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final TokenAuthenticationFilter tokenAuthenticationFilter;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                // error endpoint 열기, favicon.ico 추가
                .requestMatchers("/error", "/favicon.ico");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // rest api 설정
                .csrf(AbstractHttpConfigurer::disable)  // csrf 비활성화 -> cookie를 사용하지 않으면 꺼도 됨
//                .cors(AbstractHttpConfigurer::disable)  // cors 비활성화 -> 프론트와 연결 시 따로 설정 필요
                .httpBasic(AbstractHttpConfigurer::disable)  // 기본 인증 로그인 비활성화
                .formLogin(AbstractHttpConfigurer::disable)  // 기본 폼 로그인 비활성화
                .logout(AbstractHttpConfigurer::disable)  // 기본 로그아웃 비활성화
                .headers(c -> c.frameOptions(
                        HeadersConfigurer.FrameOptionsConfig::disable).disable())  // X-Frame-Options 비활성화
                .sessionManagement(c ->
                        c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // 세션 비활성화

                // request 인증, 인가 설정
                .authorizeHttpRequests(request ->
                        request.requestMatchers(
                                        new AntPathRequestMatcher("/"),
                                        new AntPathRequestMatcher("/login/**"),
                                        new AntPathRequestMatcher("/auth/**"),
                                        new AntPathRequestMatcher("/docs/**"),
                                        new AntPathRequestMatcher("/example/**"),
                                        new AntPathRequestMatcher("/swagger-ui/**"),
                                        new AntPathRequestMatcher("/v3/api-docs/**")
                                ).permitAll()
                                .anyRequest().authenticated()
                )

                // oauth2 설정
                .oauth2Login(oauth2 -> oauth2
//                        .authorizationEndpoint(authorization -> authorization
//                                .baseUri("/api/v1/auth/oauth2")   // oauth2 인증 요청 주소 커스텀 가능
//                        )
                                // 로그인 성공 이후 사용자 정보를 가져올 때의 설정
                                .userInfoEndpoint(userInfo ->
                                        userInfo.userService(oAuth2UserService)
                                )
                                .successHandler(oAuth2SuccessHandler)
                )

                // jwt 관련 설정
                .addFilterBefore(tokenAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new TokenExceptionFilter(),
//                        tokenAuthenticationFilter.getClass())   // 토큰 예외 핸들링

                // 인증 예외 핸들링
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new JwtAuthenticationEntryPoint())
                        .accessDeniedHandler(new JwtAccessDeniedHandler())
                );


        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

}
