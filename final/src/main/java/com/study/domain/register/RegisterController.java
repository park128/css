package com.study.domain.register;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@SessionAttributes("info")
@RequiredArgsConstructor
public class RegisterController {
	private final RegisterService registerService;
	
	// 첫 페이지
	//@GetMapping("/register/first")
	//public String openRegisterpage1() {
		// 어차피 그냥 회원가입 페이지니까 아무것도 받을 필요가 없지
		//return "register/first";
	//}
	
	 @GetMapping("/register/first")
	 public String openRegisterpage2() throws Exception{
		

        return "register/first";
    }
	 
	 @GetMapping("/register/mypage")
	 public String openmypage() throws Exception{
		

        return "register/mypage";
    }
	 //탈퇴하기
	 @GetMapping("/register/resign")
	 public String resign() throws Exception{
		

        return "register/resign";
    }
	 
	 //닉네임 바꾸기 화면
	 @GetMapping("/register/rename")
	 public String rename() throws Exception{		
        return "register/rename";
    }
	 	 
	 //우왕!!
	 
	 
	 
	@GetMapping("/register/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/register/first"; 
	}
	
	
	
	
	
	//@PostMapping("/register/first") 
	  //public String test1(@SessionAttribute(name="info", required=false) RegisterResponse info,Model model) { 
		  //model.addAttribute("info",info);

	  //return "register/first"; }
	
	
	// @GetMapping("/chat/chat")
	    //public String chatGET(HttpServletRequest request) throws Exception{
			//HttpSession session=request.getSession();
			//String name = (String)session.getAttribute("info.userId");
			//System.out.println(name);
	        //System.out.println("@ChatController, chat GET()");
	        //return "chat/chat";
	    //}
	
	// 회원가입페이지
	@GetMapping("/register/register")
	public String openRegisterpage() {
		// 어차피 그냥 회원가입 페이지니까 아무것도 받을 필요가 없지
		return "register/register";
	}
	

	// 로그인 페이지
	@GetMapping("/register/login")
	public String openLoginpage() {
		// 그냥 로그인 페이지로 갔을 때
		return "register/login";
	}

	// 회원가입 이후 정보가 db로 전달되기 위한 필요한 것
	@PostMapping("/register/save")
	public String saveRegister(final RegisterRequest params) {
		registerService.saveRegister(params);
		return "redirect:/register/login";
	}
	//아이디와 비밀번호가 맞는지
	
	
	
	
	
	
	
	
	
	
	

	//integer를 반환받는 방식으로 로그인 자체만을 구현하기 위한 것.
	@PostMapping("/register/confirm")
	public String loginsuccess(final RegisterRequest params) {

		if (registerService.loginconfirm(params) == 1) {
			return "redirect:/post/list";
		}
		return "redirect:/register/loginfail";
	}
	
	//로그인 정보를 받고 그 다음 단계로 넘어가기 위한 중간단계
	  @PostMapping("/register/middle1")
	  public String testit(final RegisterRequest params,HttpServletRequest request,RedirectAttributes rttr) { 
		  HttpSession session = request.getSession();
		  RegisterResponse info = registerService.testit(params);
		  
		
		  if(info!=null) { 
			  session.setAttribute("info", info); 
			  return "redirect:/register/first";
		} 
	  
	  return "redirect:/register/loginfail";
	  
	  }

		
	  //아이디중복검사용
	  @PostMapping("/register/checkid")
	  @ResponseBody
	  public int idCheck(final RegisterRequest params) {
		  
	      
	      int cnt = registerService.idconfig(params);
	      System.out.println(cnt);
	      return cnt;
	  }
	  
	  //탈퇴할 때 아이디와 비밀번호가 매칭되는지 확인하기 위해
	  @PostMapping("register/bothconfig")
	  @ResponseBody
	  public int bothconfig(final RegisterRequest params) {
		  int cnt = registerService.bothconfig(params);
		  System.out.println(cnt);
		  return cnt;
	  }
	  
	  
	//탈퇴하기 구현
	  @PostMapping("/register/delete")
	  @ResponseBody
	  public int delete(final RegisterRequest params) {
		  	int cnt = registerService.delete(params);
	      if(cnt==1) {
	    	  return 1;
	      }
	      
	      else {
	    	  return 0;
	      }
	      
	  }
	  //닉네임 바꾸기 구현
	  @PostMapping("/register/changename")
	  @ResponseBody
	  public int changename(final RegisterRequest params) {
		  int cnt = registerService.changename(params);
		  if(cnt==1) {
			  return 1;
		  }
		  else {
			  return 0;
		  }
	  }
	
	 
	 
	  
		
		  
		 
	  
	 
}
