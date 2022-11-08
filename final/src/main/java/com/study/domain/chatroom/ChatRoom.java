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

	    public static ChatRoom create(String name) {
	        ChatRoom room = new ChatRoom();
	        room.roomId = UUID.randomUUID().toString();
	        room.roomName = name;
	        room.chatnum=1;
	        LocalDateTime now=LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	        String formatDateTime = now.format(formatter);
	        
	        room.createdDate=formatDateTime;
	        
	        
	        return room;
	    }

}
