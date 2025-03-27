package com.example.schedule.controller;

import com.example.schedule.dto.RequstScheduleDto;
import com.example.schedule.dto.ResponseScheduleDto;
import com.example.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")

public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ResponseScheduleDto> postSchedule(@RequestBody RequstScheduleDto requstScheduleDto) {
        ResponseScheduleDto a = scheduleService.postServiceSchedule(requstScheduleDto);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseScheduleDto>> getAllSchedule() {
        List<ResponseScheduleDto> a = scheduleService.getAllServiceSchedule();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseScheduleDto> getAllScheduleId(@PathVariable Long id) {
        ResponseScheduleDto a = scheduleService.postServiceScheduleId(id);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseScheduleDto> updateSchedule(@PathVariable Long id, @RequestBody RequstScheduleDto requstScheduleDto) {
        ResponseScheduleDto a = scheduleService.updateServiceSchdeule(id, requstScheduleDto);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteServiceSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
