package com.study.domain.register;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class RegisterResponse {
	
	/* private Integer userNo; */                      
    private String registerId;                 
    private String registerPw;                
    private String registerName;               
    private String registerAuth;
    private String registerMbti;
    private String registerEmail;
    private LocalDateTime appendDate;            
    private LocalDateTime updateDate;           
    
    private String userId;                 
    private String userPw; 
    private String userName;
    private String userAuth;
    private String userMbti;
    private String userEmail;
}
