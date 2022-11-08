package com.study.domain.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ChatHandler extends TextWebSocketHandler{
	 private static List<WebSocketSession> list = new ArrayList<>();
	 private int count=0;
	    @Override
	    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	        String payload = message.getPayload();
	        System.out.println("payload: " + payload);
	        for (WebSocketSession sess : list) {
	            sess.sendMessage(message);
	        }
	    }
	    
	    // Client가 접속 시 호출되는 메서드
	    @Override
	    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	    	count+=1;
	        list.add(session);
	        System.out.println(session + " 클라이언트 접속");
	        System.out.println("현재 접속자수는"+count+"명 입니다");
	    }
	    // Client가 접속 해제 시 호출되는 메서드
	    @Override
	    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	    	count-=1;
	        System.out.println(session + " 클라이언트 접속 해제");
	        System.out.println("현재 접속자수는"+count+"명 입니다");
	        list.remove(session);
	    }

}
