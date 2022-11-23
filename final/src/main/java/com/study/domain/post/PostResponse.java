package com.study.domain.post;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class PostResponse {

    private Long id;                       // PK
    private String title;                  // 제목
    private String content;                // 내용
    private String writer;                 // 작성자
    private int viewCnt;                   // 조회 수
    private Boolean noticeYn;              // 공지글 여부
    private Boolean deleteYn;              // 삭제 여부    
	
	private LocalDateTime createdDate; // 게시글 생성일시
	

    private LocalDateTime modifiedDate;    // 최종 수정일시
    
    private Long commentId;             // 
    private String commentWriter; // 댓글 작성자
    private String comment; //댓글 내용
    private LocalDateTime commentDate; // 댓글 생성일시
    private Long commentIdentifier; //댓글 식별
}