package com.study.domain.register;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class RegisterResponse {
	
	/* private Integer userNo; */                      
    private String userId;                 
    private String userPw;                
    private String userName;               
    private String userAuth;                   
    private LocalDateTime appendDate;            
    private LocalDateTime updateDate;           
}
