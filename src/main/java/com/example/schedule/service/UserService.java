package com.example.schedule.service;

import com.example.schedule.dto.RequestUserDto;
import com.example.schedule.dto.ResponseUserDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseUserDto postUserService(RequestUserDto requestUserDto) {
        User user = new User(requestUserDto);
        User a = userRepository.save(user);
        return new ResponseUserDto(a);
    }

    public List<ResponseUserDto> getAllUserService() {
        List<User> list = userRepository.findAll();
        return list.stream().map(ResponseUserDto::new).collect(Collectors.toList());
    }

    public ResponseUserDto getIdUserService(Long id) {
        User a = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 존재하지 않습니다. ID: " + id));
        return new ResponseUserDto(a);
    }

    public ResponseUserDto updateUser(Long id, RequestUserDto requestUserDto) {
        User a = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 존재하지 않습니다. ID: " + id));
        a.update(requestUserDto);
        User b = userRepository.save(a);
        return new ResponseUserDto(b);
    }

    public void deleteUser(Long id, RequestUserDto requestUserDto) {
        User a = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 ID의 일정이 존재하지 않습니다. ID: " + id));
        userRepository.delete(a);
    }
}
