package com.example.schedule.comment.entity;


import com.example.schedule.baseEntity.BaseEntity;
import com.example.schedule.comment.dto.RequestCommentDto;
import com.example.schedule.schedule.entitiy.Schedule;
import com.example.schedule.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String commentContents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(RequestCommentDto requestCommentDto) {
        this.commentContents = requestCommentDto.getCommentContents();
    }

    public void update(RequestCommentDto requestCommentDto) {
        this.commentContents = requestCommentDto.getCommentContents();
    }
}
