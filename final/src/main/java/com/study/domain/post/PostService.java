package com.study.domain.post;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.study.common.dto.SearchDto;
import com.study.paging.Pagination;
import com.study.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public Long savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getId();
    }

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public PostResponse findPostById(final Long id) {
    	postMapper.viewCount(id);
        return postMapper.findById(id);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public Long updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getId();
    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
    public Long deletePost(final Long id) {
        postMapper.deleteById(id);
        return id;
    }

    /**
     * 게시글 리스트 조회
     * @param params - search conditions
     * @return list & pagination information
     */
    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {
        int count = postMapper.count(params);
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<PostResponse> list = postMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }
    
    
    /**
     * 댓글 저장
     * @param params - 댓글 작성자, 댓글 내용
     * @return 제대로 들어갔는지 안 들어갔는지 확인
     */
    @Transactional
    public int commentRegister(final PostRequest params) {
        int result= postMapper.commentRegister(params);
        return result;
    }
    
    
    /**
     * 댓글 리스트 조회
     * @return 댓글 리스트
     */
    public List<PostResponse> findallComment(final Long id) {
        return postMapper.findallComment(id);
    }
    /**
     * 댓글 삭제
     * @return postmapper.commentDelete를 통해 얻어온 값을 반환
     */
    @Transactional
    public int commentDelete(final PostRequest params) {
    	int result = postMapper.commentDelete(params);
    	return result;
    }

}