package com.example.schedule.schedule.service;

import org.springframework.data.domain.Pageable;
import com.example.schedule.comment.repository.CommentRepository;
import com.example.schedule.schedule.dto.RequstScheduleDto;
import com.example.schedule.schedule.dto.ResponseScheduleDto;
import com.example.schedule.schedule.entitiy.Schedule;
import com.example.schedule.schedule.repository.ScheduleRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, CommentRepository commentRepository) {
        this.scheduleRepository = scheduleRepository;
        this.commentRepository = commentRepository;
    }

    public ResponseScheduleDto postServiceSchedule(RequstScheduleDto requstScheduleDto) {
        return new ResponseScheduleDto(scheduleRepository.save(new Schedule(requstScheduleDto)));
    }

    public List<ResponseScheduleDto> getAllServiceSchedule() {
        List<Schedule> findList = scheduleRepository.findAll();
        return findList.stream().map(ResponseScheduleDto::new).collect(Collectors.toList());
    }

    public ResponseScheduleDto postServiceScheduleId(Long id) {
        return new ResponseScheduleDto(
                scheduleRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 존재하지 않습니다. ID: " + id))
        );
    }

    public ResponseScheduleDto updateServiceSchdeule(Long id, RequstScheduleDto requstScheduleDto) {
        Schedule findIdSchedule = scheduleRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 존재하지 않습니다. ID: " + id));
        findIdSchedule.update(requstScheduleDto);
        return new ResponseScheduleDto(scheduleRepository.save(findIdSchedule));
    }

    public void deleteServiceSchedule(Long id) {
        scheduleRepository.delete(scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 존재하지 않습니다. ID: " + id)));
    }

    public Page<ResponseScheduleDto> getSchedules(Pageable pageable) {
        Page<Schedule> schedules = scheduleRepository.findAll(pageable);
        return schedules.map(schedule -> new ResponseScheduleDto(schedule, commentRepository.countBySchedule(schedule))
        );
    }
}
