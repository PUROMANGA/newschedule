package com.example.schedule.schedule.dto;

import com.example.schedule.schedule.entitiy.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class ResponseScheduleDto {
    private Long id;
    private String title;
    private String content;
    private Long commentCount;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ResponseScheduleDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.userName = schedule.getUser().getName();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }

    public ResponseScheduleDto(Schedule schedule, Long commentCount) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.commentCount = commentCount;
        this.userName = schedule.getUser().getName();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
