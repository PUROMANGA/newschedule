package com.example.schedule.schedule.controller;

import com.example.schedule.schedule.service.ScheduleService;
import com.example.schedule.schedule.dto.RequstScheduleDto;
import com.example.schedule.schedule.dto.ResponseScheduleDto;
import jakarta.validation.Valid;
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

    /**
     * 스케줄 등록
     * @param requstScheduleDto
     * @return
     */

    @PostMapping
    public ResponseEntity<ResponseScheduleDto> postSchedule(@RequestBody @Valid RequstScheduleDto requstScheduleDto) {
        return new ResponseEntity<>(scheduleService.postServiceSchedule(requstScheduleDto), HttpStatus.CREATED);
    }

    /**
     * 전체 스케줄 조회
     * @return
     */

    @GetMapping
    public ResponseEntity<List<ResponseScheduleDto>> getAllSchedule() {
        return new ResponseEntity<>(scheduleService.getAllServiceSchedule(), HttpStatus.OK);
    }

    /**
     * 특정 스케줄 조회
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<ResponseScheduleDto> getAllScheduleId(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.getServiceScheduleId(id), HttpStatus.OK);
    }

    /**
     * 특정 스케쥴 조회 -> 수정
     * @param id
     * @param requstScheduleDto
     * @return
     */

    @PutMapping("/{id}")
    public ResponseEntity<ResponseScheduleDto> updateSchedule(@PathVariable Long id, @RequestBody @Valid RequstScheduleDto requstScheduleDto) {
        return new ResponseEntity<>(scheduleService.updateServiceSchdeule(id, requstScheduleDto), HttpStatus.OK);
    }

    /**
     * 특정 스케줄 조회 -> 삭제
     * @param id
     * @return
     */

    @DeleteMapping("/{id}") //특정 id 스케줄을 삭제합니다!x
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteServiceSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 페이지로 보여주기
     * @param pageable
     * @return
     */

    @GetMapping("/schedules")
    public ResponseEntity<Page<ResponseScheduleDto>> getSchedules(@PageableDefault(size = 10, sort = "modifiedAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(scheduleService.getSchedules(pageable), HttpStatus.OK);
    }
}
