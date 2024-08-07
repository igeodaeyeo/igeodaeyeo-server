package com.igdy.igeodaeyeo.global.security;

import com.igdy.igeodaeyeo.domain.user.entity.User;
import com.igdy.igeodaeyeo.domain.user.repository.UserRepository;
import com.igdy.igeodaeyeo.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 로그인 정보 가져와 가공하기
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    // DefaultOAuth2UserService: 리소스 서버에서 사용자 정보를 가져오는 클래스

    private final UserRepository userRepository;

    @Transactional
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        // 1. user 정보 가져오기
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // 2. registrationId 가져오기 (third-party id) -> for google, kakao
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // 3. userNameAttributeName 가져오기: user-name-attribute 값
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        // 4. user 정보 dto 생성
        OAuth2UserInfo oAuth2UserInfo;
        if (registrationId.equals("naver")) {
            oAuth2UserInfo = new NaverUserInfo(oAuth2User.getAttributes());
        } else if (registrationId.equals("kakao")) {
            oAuth2UserInfo = new KakaoUserInfo(oAuth2User.getAttributes());
        } else {
            throw new AuthException(ErrorCode.ILLEGAL_REGISTRATION_ID);
        }

        // 5. 회원가입 및 로그인
        User user = getOrSave(oAuth2UserInfo);

        // 6. OAuth2User로 변환
        return new PrincipalDetails(user, oAuth2User.getAttributes());
    }

    private User getOrSave(OAuth2UserInfo oAuth2UserInfo) {
        User user = userRepository.findByLoginId(oAuth2UserInfo.getEmail())
                .orElseGet(oAuth2UserInfo::toEntity);

        return userRepository.save(user);
    }
}
