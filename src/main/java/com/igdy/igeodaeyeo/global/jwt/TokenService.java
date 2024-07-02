package com.igdy.igeodaeyeo.global.jwt;

import com.igdy.igeodaeyeo.global.exception.ErrorCode;
import com.igdy.igeodaeyeo.global.exception.TokenException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    @Transactional
    public void saveOrUpdate(String memberKey, String accessToken, String refreshToken) {
        Token token = tokenRepository.findByAccessToken(accessToken)
                .map(t -> t.updateRefreshToken(refreshToken))
                .orElseGet(() -> new Token(memberKey, accessToken, refreshToken));

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

    public void deleteRefreshToken(String memberKey) {
        tokenRepository.deleteById(memberKey);
    }
}
