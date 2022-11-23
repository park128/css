package com.study.domain.chat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("info")
@Controller
public class ChatController {
   @Autowired
   ChatHandler chathandler;

   //"chat/chat"화면에 접속하기 위한 Controller
   @GetMapping("/chat/chat")
   public String method2(HttpServletRequest request,Model model) throws Exception{
      HttpSession session=request.getSession();
      if(session.getAttribute("info")!=null) {
         //session에 저장된 info값이 존재한다면 해당 코드를 실행한다.
    	  int count = ChatHandler.list.size(); //새로운 사용자가 들어올 때마다 list에 추가가 되므로 count는 현재 접속한 인원을 나타낸다.
    	  
    	  model.addAttribute("count",count); // model에 count의 값을 저장한다.
    	  
    	  System.out.println("컨트롤러 화면리턴 직전/chat/chat"+count+"명입니다");
         

            return "/chat/chat";
      }
      else {
         //session에 저장된 info값이 존재하지 않는다면 로그인이 되지 않은 상태로 채팅창 사이트에 접속한 것을 의미하므로 로그인 화면으로 넘어가게 한다.
         return"redirect:/fail";
      }
   }


}