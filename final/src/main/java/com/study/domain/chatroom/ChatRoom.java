package com.study.domain.chatroom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoom {
	 private String roomId;
	 private String roomName;
	 private Integer chatnum;
	 private String createdDate; 
	 private String roomMaker;
	 private Integer participant;

	    public static ChatRoom create(String name,String maker) {
	        ChatRoom room = new ChatRoom();
	        room.roomId = UUID.randomUUID().toString();
	        room.roomName = name;
	        room.roomMaker=maker;
	   
	        LocalDateTime now=LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formatDateTime = now.format(formatter);	        
	        room.createdDate=formatDateTime;
	        
	        room.participant=0;
	        
	        
	        return room;
	    }

}
