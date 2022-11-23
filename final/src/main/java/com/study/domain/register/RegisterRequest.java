package com.study.domain.register;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterRequest {
	
	/*
	 * private Integer userNo; // PK
	 */    
	private String registerId;        // 아이디
    private String registerPw;      // 비밀번호
    private String registerName;       // 닉네임
    private String registerEmail;  // 이메일
    private String registerMbti;  // MBTI
    
    private String userId;        // 로그인 아이디
    private String userPw;      // 로그인 비밀번호
    private String userName;
    private String userEmail;
    private String userMbti;
}
