package com.study.domain.post;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.common.dto.MessageDto;
import com.study.common.dto.SearchDto;
import com.study.domain.register.RegisterRequest;
import com.study.domain.register.RegisterResponse;
import com.study.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Controller
@SessionAttributes("info")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/post/write")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "post/write";
    }
    
    // 신규 게시글 생성
    @PostMapping("/post/save")
    public String savePost(final PostRequest params, Model model) {
        postService.savePost(params);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/list", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 리스트 페이지
    @GetMapping("/post/list")
    public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
    	PagingResponse<PostResponse> response = postService.findAllPost(params);   	   	
        model.addAttribute("response", response);     
        return "post/list";
    }
	  	  
	  
    // 게시글 상세 페이지
    @GetMapping("/post/view")
    public String openPostView(@RequestParam final Long id, Model model) {
        PostResponse post = postService.findPostById(id);
		 List<PostResponse> commentPost = postService.findallComment(id);
		 System.out.println("글상세보기 컨트롤러에서 받아온 댓글 리스트");
		 for (int i = 0; i < commentPost.size(); i++) {
			 System.out.println(commentPost.get(i));
		 }
		 model.addAttribute("post", post);
		 model.addAttribute("commentPost",commentPost); 
        
        return "post/view";
    }
    
    // 기존 게시글 수정
    @PostMapping("/post/update")
    public String updatePost(final PostRequest params, Model model) {
        postService.updatePost(params);
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/post/list", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }
    
    //로그아웃
    @GetMapping("/post/logout")
    	public String logout(HttpSession session) {
    		session.invalidate(); //session.invalidate()를 통해 session안에 있던 정보 삭제
    		return "register/login";
    }
    
    // 게시글 삭제
    @PostMapping("/post/delete")
    public String deletePost(@RequestParam final Long id,
                             @RequestParam final Map<String, Object> queryParams,
                             Model model) {

        postService.deletePost(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/list", RequestMethod.GET, queryParams);
        return showMessageAndRedirect(message, model);
    }
    
    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
    
    
 	//댓글 추가
 	@PostMapping("/post/comment")
 	@ResponseBody
 	public int commentRegister(final PostRequest params) {
 		int cnt = postService.commentRegister(params); // postService에 있는 commentRegister 함수를 실행
 		System.out.println(cnt); //제대로 쿼리를 통해 값을 받아오고 있는지 확인
 		return cnt;
 	}
 	
 	//댓글 삭제
 	@PostMapping("/post/commentDelete")
 	@ResponseBody
 	public int commentDelete(final PostRequest params) {
 		System.out.println("컨트롤러 실행완료");
 		int cnt = postService.commentDelete(params); 
 		return cnt;
 	}
 	
 	
 	
    

}