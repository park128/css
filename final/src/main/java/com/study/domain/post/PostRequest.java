package com.study.domain.post;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {

    private Long id;             // PK
    private String title;        // 제목
    private String content;      // 내용
    private String writer;       // 작성자
    private Boolean noticeYn;    // 공지글 여부
    
    private String commentWriter; // 댓글 작성자
    private String comment; //댓글 내용
    private Long commentId;             // 
    private LocalDateTime commentDate; // 댓글 생성일시
    private Long commentIdentifier; //댓글 식별
}