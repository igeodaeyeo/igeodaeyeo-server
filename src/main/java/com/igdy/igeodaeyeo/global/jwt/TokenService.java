package com.igdy.igeodaeyeo.global.jwt;

import com.igdy.igeodaeyeo.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    @Transactional
    public void saveOrUpdate(String userKey, String accessToken, String refreshToken) {
        Token token = tokenRepository.findByAccessToken(accessToken)
                .map(t -> t.updateRefreshToken(refreshToken))
                .orElseGet(() -> new Token(userKey, accessToken, refreshToken));

        tokenRepository.save(token);
    }

    @Transactional
    public void updateToken(String accessToken, Token token) {
        token.updateAccessToken(accessToken);
        tokenRepository.save(token);
    }

    public Token findByAccessTokenOrThrow(String accessToken) {
        return tokenRepository.findByAccessToken(accessToken)
                .orElseThrow(() -> new TokenException(ErrorCode.TOKEN_EXPIRED));
    }

    public void deleteRefreshToken(String userKey) {
        tokenRepository.deleteById(userKey);
    }
}
