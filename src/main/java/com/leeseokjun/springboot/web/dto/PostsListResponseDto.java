package com.leeseokjun.springboot.web.dto;

import com.leeseokjun.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    //전체조회하기
    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate=entity.getModifiedDate();
       // this.modifiedDate = entity.getModifiedDate();
    }
}
