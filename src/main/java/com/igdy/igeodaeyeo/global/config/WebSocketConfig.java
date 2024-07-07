package com.igdy.igeodaeyeo.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 메세지 브로커 구성 메서드
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // 구독 url (/sub/{chatNo}/로 주제 구독 가능)
        config.setApplicationDestinationPrefixes("/app"); // prefix 정의 (/pub/message로 메세지 전송 라우팅 가능)
    }

    // STOMP 엔드포인트 등록 메서드
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") // socket 연결 url (STOMP 엔드포인트 지정)
                .setAllowedOriginPatterns("*") // CORS 허용 범위
                .withSockJS(); // SockJS 사용 가능 설정
    }
}
