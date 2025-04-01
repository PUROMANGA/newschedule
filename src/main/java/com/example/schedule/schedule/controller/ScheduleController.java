package com.example.schedule.schedule.controller;

import com.example.schedule.schedule.service.ScheduleService;
import com.example.schedule.schedule.dto.RequstScheduleDto;
import com.example.schedule.schedule.dto.ResponseScheduleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/schedule")

public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping //스케줄을 등록합니다!
    public ResponseEntity<ResponseScheduleDto> postSchedule(@RequestBody RequstScheduleDto requstScheduleDto) {
        return new ResponseEntity<>(scheduleService.postServiceSchedule(requstScheduleDto), HttpStatus.CREATED);
    }

    @GetMapping //등록한 전체 스케줄을 조회합니다!
    public ResponseEntity<List<ResponseScheduleDto>> getAllSchedule() {
        return new ResponseEntity<>(scheduleService.getAllServiceSchedule(), HttpStatus.OK);
    }

    @GetMapping("/{id}")//특정 id 스케줄을 조회합니다!
    public ResponseEntity<ResponseScheduleDto> getAllScheduleId(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.postServiceScheduleId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}") //특정 id 스케줄을 수정합니다!
    public ResponseEntity<ResponseScheduleDto> updateSchedule(@PathVariable Long id, @RequestBody RequstScheduleDto requstScheduleDto) {
        return new ResponseEntity<>(scheduleService.updateServiceSchdeule(id, requstScheduleDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //특정 id 스케줄을 삭제합니다!
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteServiceSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/schedules")
    public ResponseEntity<Page<ResponseScheduleDto>> getSchedules(@PageableDefault(size = 10, sort = "modifiedAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(scheduleService.getSchedules(pageable), HttpStatus.OK);
    }
}
