package com.example.schedule.comment.dto;

import com.example.schedule.comment.entity.Comment;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter

public class ResponseCommentDto {
    private Long id;
    private String commentContents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ResponseCommentDto(Comment comment) {
        this.id = comment.getId();
        this.commentContents = comment.getCommentContents();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
