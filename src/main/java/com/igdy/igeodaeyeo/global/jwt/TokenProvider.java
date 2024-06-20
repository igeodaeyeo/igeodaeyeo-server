package com.igdy.igeodaeyeo.global.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenProvider {
    // 토큰 발급

    private static final String BEARER_TYPE = "Bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30L;           // 30분
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60L * 24 * 7; // 7일
    private static final String KEY_ROLE = "role";
//    private final TokenService tokenService;

    private final Key key;

    public TokenProvider(@Value("${spring.jwt.secret-key}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(Authentication authentication) {
        return generateToken(authentication, ACCESS_TOKEN_EXPIRE_TIME);
    }

    // 1. refresh token 발급
    public void generateRefreshToken(Authentication authentication, String accessToken) {
        String refreshToken = generateToken(authentication, REFRESH_TOKEN_EXPIRE_TIME);
//        tokenService.saveOrUpdate(authentication.getName(), refreshToken, accessToken); // redis에 저장?

        // 나중에 refresh token db에 저장해야한다!!
    }

    private String generateToken(Authentication authentication, long expireTime) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + expireTime);

        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(KEY_ROLE, authorities)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public TokenDto generateTokenDto(Authentication authentication) {
        String accessToken = generateAccessToken(authentication);
        String refreshToken = generateToken(authentication, REFRESH_TOKEN_EXPIRE_TIME);
        Date accessTokenExpiresIn = new Date((new Date()).getTime() + ACCESS_TOKEN_EXPIRE_TIME);

        return TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .grantType(BEARER_TYPE)
                .expiresIn(accessTokenExpiresIn.getTime())
                .build();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = parseClaims(token);
        List<SimpleGrantedAuthority> authorities = getAuthorities(claims);

        // 2. security의 User 객체 생성: DB에 접근하지 않기 위해
        User principals = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principals, token, authorities);
    }

    private List<SimpleGrantedAuthority> getAuthorities(Claims claims) {
        return Collections.singletonList(new SimpleGrantedAuthority(
                claims.get(KEY_ROLE).toString())
        );
    }

    // 3. access token은 redis에 저장된 refresh token을 통해 재발급
//    public String reissueAccessToken(String accessToken) {
//        if (StringUtils.hasText(accessToken)) {
//            Token token = tokenService.findByAccessTokenOrThrow(accessToken);
//            String refreshToken = token.getRefreshToken();
//
//            if (validateToken(refreshToken)) {
//                String reissueAccessToken = generateAccessToken(getAuthentication(refreshToken));
//                tokenService.updateToken(reissueAccessToken, token);
//                return reissueAccessToken;
//            }
//        }
//        return null;
//    }

    public boolean validateToken(String token) {
        if (!StringUtils.hasText(token)) {
            return false;
        }

        Claims claims = parseClaims(token);
        return claims.getExpiration().after(new Date());
    }

    private Claims parseClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        } catch (MalformedJwtException | SecurityException e) {
            System.out.println("잘못된 JWT 토큰입니다.");
            return null;
        } catch (UnsupportedJwtException e) {
            System.out.println("지원되지 않는 JWT 서명입니다.");
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("JWT 토큰이 잘못되었습니다.");
            return null;
        }
    }
}
