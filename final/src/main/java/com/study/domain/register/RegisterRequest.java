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
	private String userId;        // 아이디
    private String userPw;      // 비밀번호
    private String userName;       // 닉네임
    private String userEmail;  // 이메일
    private String userMbti;  // MBTI
}
