package com.study.domain.chatroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {
	
	private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    //채팅방 불러오기
    public List<ChatRoom> findAllRoom() {
        //채팅방 최근 생성 순으로 반환
        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
        Collections.reverse(result);

        return result;
    }

    //채팅방 하나 불러오기
    public ChatRoom findById(String roomId) {
        return chatRooms.get(roomId);
    }

    //채팅방 생성
    public ChatRoom createRoom(String name,String maker) {
        ChatRoom chatRoom = ChatRoom.create(name,maker);     
        chatRooms.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }
    //채팅방 전체 삭제(테스트용)
    public void deleteRoom() {
    	chatRooms.clear();
    }
    
    //채팅방 삭제 제대로
    public void deleteRoom1(String name) {
    	chatRooms.remove(name);
    	
    }
    
    //입장인원 추가
    public void updateParticipant(String roomId) {
    	int a= chatRooms.get(roomId).getParticipant();    	  	
    	a+=1;
    	chatRooms.get(roomId).setParticipant(a);    	      
    	
    }
    
    //입장인원 없애기
    public int minusParticipant(String roomId) {
    	int a= chatRooms.get(roomId).getParticipant();   		
    	a-=1;
    	chatRooms.get(roomId).setParticipant(a);
    	return a;
    }

}
