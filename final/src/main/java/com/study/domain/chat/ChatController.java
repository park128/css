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
	ChatHandler howMany;

	//1번째
	//@GetMapping("/chat/chat")
	//public String method1(HttpServletRequest request) throws Exception{
		//HttpSession session=request.getSession();
		//if(session!=null) {
			//return "redirect:/success";
		//}
		//else {
		//	return"redirect:/fail";
		//}		
	//}
	//2번쨰
	@GetMapping("/chat/chat")
	public String method2(HttpServletRequest request,Model model) throws Exception{
		HttpSession session=request.getSession();
		if(session.getAttribute("info")!=null) {
			//session에 저장된 info값이 존재한다면 해당 코드를 실행한다.
			int count=howMany.getCount();
			 model.addAttribute("count",count);
			 System.out.println(count+"명입니당");
	         System.out.println("@ChatController, chat GET()");
	         return "chat/chat";
		}
		else {
			//session에 저장된 info값이 존재하지 않는다면 해당 코드를 실행한다.
			return"redirect:/fail";
		}
	}

	


}
