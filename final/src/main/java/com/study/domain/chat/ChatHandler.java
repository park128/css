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
    static List<WebSocketSession> list = new ArrayList<>(); 
    
       @Override
       protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	 
           String payload = message.getPayload();
           
           TextMessage newMessage = new TextMessage(payload+":"+list.size()); //받아온 메시지에 list.size()를 추가해서 넣어준다.
           
           
           for (WebSocketSession sess : list) {   //리스트는 소켓세션들을 담고있는 배열
               sess.sendMessage(newMessage); // 이걸 바꾼다
              
           }
       }
       
       // Client가 접속 시 호출되는 메서드
       @Override
       public void afterConnectionEstablished(WebSocketSession session) throws Exception {
          System.out.println("핸들러 접속함수 시작");         
           list.add(session);       
           System.out.println(session + " 클라이언트 접속");
           System.out.println("현재 접속자수는"+"명 입니다");
           System.out.println("핸들러끝 접속함수 끝");
       }
       // Client가 접속 해제 시 호출되는 메서드
       @Override
       public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
          System.out.println("핸들러 종료함수 시작");    
           System.out.println(session + " 클라이언트 접속 해제");
           System.out.println("현재 접속자수는"+"명 입니다");
           list.remove(session);
           System.out.println("핸들러 종료함수 끝");
       }
       

}