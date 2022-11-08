package com.study.domain.chatroom;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.RequiredArgsConstructor;
@SessionAttributes("info")
@Controller
@RequiredArgsConstructor

public class ChatRoomController {
	 private final ChatService chatService;


	    // 채팅 리스트 화면
	    @GetMapping("chatroom/room")
	    public String rooms(Model model) throws Exception{
	        return "/chatroom/room";
	    }
	    // 모든 채팅방 목록 반환
	    @GetMapping("chatroom/rooms")
	    @ResponseBody
	    public List<ChatRoom> room() throws Exception{
	        return chatService.findAllRoom();
	    }
	    
	    @GetMapping("chatroom/makeroom")
	    public String makeroom() throws Exception{
	    	return"/chatroom/makeroom";
	    }
	    
	    
	    // 채팅방 생성
	    @PostMapping("chatroom/room")
	    @ResponseBody
	    public ChatRoom createRoom(@RequestParam String name) throws Exception{
	        return chatService.createRoom(name);
	    }
	    
	    
	    // 채팅방 입장 화면
	    @GetMapping("chatroom/room/enter/{roomId}")
	    public String roomDetail(Model model, @PathVariable String roomId) throws Exception{
	        model.addAttribute("roomId", roomId);
	        return "/chatroom/roomdetail";
	    }
	    // 특정 채팅방 조회
	    @GetMapping("chatroom/room/{roomId}")
	    @ResponseBody
	    public ChatRoom roomInfo(@PathVariable String roomId) throws Exception{
	        return chatService.findById(roomId);
	    }

}
