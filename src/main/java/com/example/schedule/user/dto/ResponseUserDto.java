package com.example.schedule.user.dto;

import com.example.schedule.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class ResponseUserDto {
    private Long id;
    private String name;
    private String email;
    private String pw;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ResponseUserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.pw = user.getPw();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
    }
}
