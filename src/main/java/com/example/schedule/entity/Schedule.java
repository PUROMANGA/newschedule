package com.example.schedule.entity;

import com.example.schedule.dto.RequstScheduleDto;
import com.example.schedule.dto.ResponseScheduleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Table(name = "schedule")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Schedule(RequstScheduleDto requstScheduleDto) {
        this.title = requstScheduleDto.getTitle();
        this.content = requstScheduleDto.getContent();
    }

    public void update(RequstScheduleDto requstScheduleDto) {
        this.title = requstScheduleDto.getTitle();
        this.content = requstScheduleDto.getContent();
    }
}
