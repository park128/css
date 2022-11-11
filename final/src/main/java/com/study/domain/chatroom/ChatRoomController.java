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
	    public ChatRoom createRoom(@RequestParam String name,@RequestParam String maker) throws Exception{
	        return chatService.createRoom(name,maker);
	    }
	    
	    
	    // 채팅방 입장 화면
	    @GetMapping("chatroom/room/enter/{roomId}")
	    public String roomDetail(Model model, @PathVariable String roomId) throws Exception{
	    	
	    	chatService.updateParticipant(roomId);
	        model.addAttribute("roomId", roomId);
	        return "/chatroom/roomdetail";
	    }
	    // 특정 채팅방 조회
	    @GetMapping("chatroom/room/{roomId}")
	    @ResponseBody
	    public ChatRoom roomInfo(@PathVariable String roomId) throws Exception{
	    	
	    	
	        return chatService.findById(roomId);
	    }
	    
	    
	    
	    //이게 지우는거 테스트하려고 추가한 것(다짜고짜 다 지우기)
	    @GetMapping("chatroom/erase")
	    public String erase() throws Exception{
	    	chatService.deleteRoom();
	    	return "/chatroom/room";
	    }
	    
	    
	    // 지정된 것만 지우기
	    @PostMapping("chatroom/eraseit")
	    @ResponseBody
	    public String erase1(@RequestParam String name) throws Exception{
	    	chatService.deleteRoom1(name);
	    	return "/chatroom/room";
	    }
	    
	    
	    //나갈 때 어디로 연결될 것인지 + 인원 삭제
	    @GetMapping("chatroom/room/exit/{roomId}")
	    @ResponseBody
	    public int getOut(@PathVariable String roomId) throws Exception{
	    	//나가니까 인원 -1해야겠지?	    	
	        System.out.println("여기까지는 됨1");
	        int b = chatService.minusParticipant(roomId);
	        return b;
	      
	    }
	    


}
