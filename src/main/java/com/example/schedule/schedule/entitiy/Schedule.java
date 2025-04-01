package com.example.schedule.schedule.entitiy;

import com.example.schedule.baseEntity.BaseEntity;
import com.example.schedule.user.entity.User;
import com.example.schedule.schedule.dto.RequstScheduleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule(RequstScheduleDto requstScheduleDto) {
        this.title = requstScheduleDto.getTitle();
        this.content = requstScheduleDto.getContent();
    }

    public void update(RequstScheduleDto requstScheduleDto) {
        this.title = requstScheduleDto.getTitle();
        this.content = requstScheduleDto.getContent();
    }
}
