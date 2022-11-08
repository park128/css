package com.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class ChatConfig implements WebSocketMessageBrokerConfigurer{
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws/chatroom").setAllowedOriginPatterns("*").withSockJS();
        //addEndPoint():클라이언트에서 websocket에 접속하기 위한 endpoint를 등록
    }
	@Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.enableSimpleBroker("/queue", "/topic");
        // enableSimpleBroker(): 메모리 기반 메시지 브로커가 /topic접두사가 붙은 클라이언트로 메시지를 전달할 수 있도록 설정, 쉽게 이야기하면 클라이언트 A,B,C가 각각
        // /topic/master, /topic/sub, /topic/master를 구독하고 있을 때 /topic/master로 메시지를 전송하면 클라이언트 A,C만 메시지를 받는 구조이다.
        registry.setApplicationDestinationPrefixes("/app");
        // /app으로 접근하는 메시지만 핸들러로 라우팅
    }

}
