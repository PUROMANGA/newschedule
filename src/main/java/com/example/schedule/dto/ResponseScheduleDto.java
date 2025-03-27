package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter

public class ResponseScheduleDto {
    private Long id;
    private String name;
    private String title;
    private String content;
    private String createdAt;
    private String modifiedAt;

    public ResponseScheduleDto(Schedule a) {
        this.id = a.getId();
        this.name = a.getName();
        this.title = a.getTitle();
        this.content = a.getContent();
        this.createdAt = a.getCreatedAt().format(DateTimeFormatter.BASIC_ISO_DATE);
        this.modifiedAt = a.getModifiedAt().format(DateTimeFormatter.BASIC_ISO_DATE);
    }
}
