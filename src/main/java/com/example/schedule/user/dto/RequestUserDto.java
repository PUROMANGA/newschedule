package com.example.schedule.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RequestUserDto {

    @NotBlank(message = "유저명을 입력해주세요")
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일을 넣어주세요.")
    private String email;

    @NotBlank(message = "패스워드를 입력해주세요.")
    private String pw;

    public RequestUserDto(String name, String email, String pw) {
        this.name = name;
        this.email = email;
        this.pw = pw;
    }
}