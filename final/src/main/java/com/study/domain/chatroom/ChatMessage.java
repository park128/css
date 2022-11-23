package com.study.domain.chatroom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
	public enum MessageType {
        ENTER, TALK, QUIT
    }
	
    private MessageType type;
    //채팅방 ID
    private String roomId;
    //보내는 사람
    private String sender;
    //내용
    private String message;
    //채팅방 인원수
    private long userCount;
    //방이름
    private String roomName;
       
}
