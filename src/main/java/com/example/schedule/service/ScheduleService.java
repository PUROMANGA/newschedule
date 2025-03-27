package com.example.schedule.service;

import com.example.schedule.dto.RequstScheduleDto;
import com.example.schedule.dto.ResponseScheduleDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ResponseScheduleDto postServiceSchedule(RequstScheduleDto requstScheduleDto) {
        Schedule schedule = new Schedule(requstScheduleDto);
        Schedule a = scheduleRepository.save(schedule);
        return new ResponseScheduleDto(a);
    }

    public List<ResponseScheduleDto> getAllServiceSchedule() {
        List<Schedule> findList = scheduleRepository.findAll();
        return findList.stream().map(ResponseScheduleDto::new).collect(Collectors.toList());
    }

    public ResponseScheduleDto postServiceScheduleId(Long id) {
        Schedule a = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 존재하지 않습니다. ID: " + id));
        return new ResponseScheduleDto(a);
    }

    public ResponseScheduleDto updateServiceSchdeule(Long id, RequstScheduleDto requstScheduleDto) {
        Schedule a = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 존재하지 않습니다. ID: " + id));
        a.update(requstScheduleDto);
        Schedule b = scheduleRepository.save(a);
        return new ResponseScheduleDto(b);
    }

    public void deleteServiceSchedule(Long id) {
        Schedule a = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 존재하지 않습니다. ID: " + id));
        scheduleRepository.delete(a);
    }
}
