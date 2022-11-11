package com.study.domain.register;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService {
	private final RegisterMapper registerMapper;
	
	//회원가입 할 때!
	 @Transactional
	    public void saveRegister(final RegisterRequest params) {
	        registerMapper.register(params);
	       
	    }
	 
	 /**
	     * 게시글 상세정보 조회
	     * @param id - PK
	     * @return 게시글 상세정보
	     */
	    public RegisterResponse findAll(final Integer user_no) {
	        return registerMapper.findByuserno(user_no);
	    }
	    
	    public Integer loginconfirm(final RegisterRequest params) {
	    	System.out.println(registerMapper.login(params));
	    	return registerMapper.login(params);
	    	}
	    
		//처음 로그인할 때 로그인 검증 용도
		public RegisterResponse loginVerify(final RegisterRequest params) { 
			System.out.println("이게 service");
			System.out.println(params);
			System.out.println(registerMapper.loginVerify(params));
			return registerMapper.loginVerify(params); }
		
		
		public Integer idconfig(final RegisterRequest params) {
			return registerMapper.idconfig(params);
		}
		//아이디 삭제 구현
		public Integer delete(final RegisterRequest params) {
			return registerMapper.delete(params);
		}
		//아이디와 비밀번호가 매칭되는지 확인
		public Integer bothconfig(final RegisterRequest params) {
			return registerMapper.bothconfig(params);
		}
		
		//닉네임 변경 구현
		public Integer changename(final RegisterRequest params) {
			return registerMapper.changename(params);
		}
	   
	
}
