package com.example.schedule.schedule.entitiy;

import com.example.schedule.baseEntity.BaseEntity;
import com.example.schedule.comment.entity.Comment;
import com.example.schedule.user.entity.User;
import com.example.schedule.schedule.dto.RequstScheduleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comment;

    public Schedule(RequstScheduleDto requstScheduleDto) {
        this.title = requstScheduleDto.getTitle();
        this.content = requstScheduleDto.getContent();
    }

    public void update(RequstScheduleDto requstScheduleDto) {
        this.title = requstScheduleDto.getTitle();
        this.content = requstScheduleDto.getContent();
    }
}
