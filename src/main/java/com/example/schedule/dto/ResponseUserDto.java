package com.example.schedule.dto;

import com.example.schedule.entity.User;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter

public class ResponseUserDto {
    private Long id;
    private String name;
    private String email;
    private String pw;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ResponseUserDto(User a) {
        this.id = a.getId();
        this.name = a.getName();
        this.email = a.getEmail();
        this.pw = a.getPw();
        this.createdAt = a.getCreatedAt();
        this.modifiedAt = a.getModifiedAt();
    }
}
