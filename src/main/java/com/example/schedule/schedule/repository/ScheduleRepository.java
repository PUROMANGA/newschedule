package com.example.schedule.schedule.repository;

import com.example.schedule.schedule.entitiy.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
