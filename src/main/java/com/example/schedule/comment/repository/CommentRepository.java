package com.example.schedule.comment.repository;

import com.example.schedule.comment.entity.Comment;
import com.example.schedule.schedule.entitiy.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Long countBySchedule(Schedule schedule);
}
