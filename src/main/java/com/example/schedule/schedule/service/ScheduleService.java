package com.example.schedule.schedule.service;

import com.example.schedule.exception.CustomException;
import com.example.schedule.exception.ExceptionErrorCode;
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

    /**
     * 스케줄 등록
     * @param requstScheduleDto
     * @return
     */

    public ResponseScheduleDto postServiceSchedule(RequstScheduleDto requstScheduleDto) {
        return new ResponseScheduleDto(scheduleRepository.save(new Schedule(requstScheduleDto)));
    }

    /**
     * 스케쥴 전체 조회
     * @return
     */

    public List<ResponseScheduleDto> getAllServiceSchedule() {
        List<Schedule> findList = scheduleRepository.findAll();
        return findList.stream().map(ResponseScheduleDto::new).collect(Collectors.toList());
    }

    /**
     * 스케쥴 조회
     * @param id
     * @return
     */

    public ResponseScheduleDto getServiceScheduleId(Long id) {
        return new ResponseScheduleDto(
                scheduleRepository
                        .findById(id)
                        .orElseThrow(() -> new CustomException(ExceptionErrorCode.DEFAULT_ERROR_MESSAGE)));
    }

    /**
     * id 조회 -> 스케줄 수정
     * @param id
     * @param requstScheduleDto
     * @return
     */

    public ResponseScheduleDto updateServiceSchdeule(Long id, RequstScheduleDto requstScheduleDto) {
        Schedule findIdSchedule = scheduleRepository
                .findById(id)
                .orElseThrow(() -> new CustomException(ExceptionErrorCode.DEFAULT_ERROR_MESSAGE));
        findIdSchedule.update(requstScheduleDto);
        return new ResponseScheduleDto(scheduleRepository.save(findIdSchedule));
    }

    /**
     * id 조회 -> 스케줄 삭제
     * @param id
     */

    public void deleteServiceSchedule(Long id) {
        scheduleRepository.delete(scheduleRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionErrorCode.DEFAULT_ERROR_MESSAGE)));
    }

    /**
     * 페이지 만들어주기
     * @param pageable
     * @return
     */

    public Page<ResponseScheduleDto> getSchedules(Pageable pageable) {
        Page<Schedule> schedules = scheduleRepository.findAll(pageable);
        return schedules.map(schedule -> new ResponseScheduleDto(schedule, commentRepository.countBySchedule(schedule))
        );
    }
}
