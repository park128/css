package com.study.domain.register;


import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RegisterMapper {
	
	/**
     * 회원정보 저장
     * @param params - 회원 정보
     */
    void register(RegisterRequest params);
    
    
    RegisterResponse findByuserno(Integer userNo);
    
    
    int login(RegisterRequest params);
    
    //처음 로그인할 때 로그인 검증 용도
	RegisterResponse loginVerify(RegisterRequest params); 
	
	
	/**
     * 아이디 중복 확인
     * @param params - 회원 정보
     */
	int idconfig(RegisterRequest params);
	
	
	//아이디와 비밀번호 입력하고 삭제
	int delete(RegisterRequest params);
	
	
	//아이디와 비밀번호가 매칭되는지를 확인하기위해(탈퇴하기 할 때 사용)
	int bothconfig(RegisterRequest params);
	
	
	//닉네임 바꾸기 구현
	int changename(RegisterRequest params);
	
}
