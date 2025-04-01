package com.example.schedule.schedule.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter

public class RequstScheduleDto {

    @NotBlank(message = "제목을 적어주세요.")
    private String title;

    private String content;
    //내용 없이 스케줄을 등록하는 경우가 저는 많아서 내용은 notblank를 적용하지 않았습니다.
}
