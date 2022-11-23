package com.study.domain.post;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.common.dto.SearchDto;

@Mapper
public interface PostMapper {

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(PostRequest params);

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    PostResponse findById(Long id);
    
    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(PostRequest params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);
    
    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findAll(SearchDto params);

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count(SearchDto params);
    /**
     * 상세글 보기 하면 조회수 1증가
     * @return 게시글 수
     */
    void viewCount(Long id);
    
    /**
     * 댓글 등록
     * @return 댓글 등록 성공 여부
     * 성공하면 1반환 그렇지 않으면 0반환
     */
    int commentRegister(PostRequest params);
    
    
    /**
     * 상세 게시판 조회글 안의 모든 댓글 조회(id를 기준으로 검색)
     * @return 게시글 수
     */
    List<PostResponse> findallComment(Long id);
   
    /**
     * 댓글 삭제
     * @return 삭제된 댓글의 수(즉, 삭제를 성공하면 1, 그렇지 않다면 0)
     */
    int commentDelete(PostRequest params);

}