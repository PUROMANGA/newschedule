package com.example.schedule.comment.repository;

import com.example.schedule.comment.entity.Comment;
import com.example.schedule.schedule.entitiy.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends JpaRepository<Comment, Long> {
    /**
     * 스케쥴로 코멘트 갯수 카운팅
     * @param schedule
     * @return
     */
    Long countBySchedule(Schedule schedule);
}
