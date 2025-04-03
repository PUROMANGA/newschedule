package com.example.schedule.user.service;

import com.example.schedule.exception.CustomException;
import com.example.schedule.exception.ExceptionErrorCode;
import com.example.schedule.user.dto.RequestUserDto;
import com.example.schedule.user.dto.ResponseUserDto;
import com.example.schedule.user.entity.User;
import com.example.schedule.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseUserDto postUserService(RequestUserDto requestUserDto) {
        return new ResponseUserDto(userRepository.save(new User(requestUserDto)));
    }

    public List<ResponseUserDto> getAllUserService() {
        List<User> list = userRepository.findAll();
        return list.stream().map(ResponseUserDto::new).collect(Collectors.toList());
    }

    public ResponseUserDto getIdUserService(Long id) {
        return new ResponseUserDto(userRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionErrorCode.DEFAULT_ERROR_MESSAGE)));
    }

    public ResponseUserDto updateUser(Long id, RequestUserDto requestUserDto) {
        User findIdUser = userRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionErrorCode.DEFAULT_ERROR_MESSAGE));
        findIdUser.update(requestUserDto);

        return new ResponseUserDto(
                userRepository.save(findIdUser));
    }

    public void deleteUser(Long id, RequestUserDto requestUserDto) {
        userRepository.delete(userRepository.findById(id).orElseThrow(() -> new CustomException(ExceptionErrorCode.DEFAULT_ERROR_MESSAGE)));
    }

    public ResponseUserDto saveUser(String email, String pw) {
        if(userRepository.existsByEmail(email)) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }

        String encodePw = passwordEncoder.encode(pw);

        User makeuser = new User(email, encodePw);

        return new ResponseUserDto(
                userRepository.save(makeuser)
        );
    }

    public ResponseUserDto findUser(String email, String pw) {
        User findedUserService = userRepository.findByEmail(email).orElseThrow(() -> new CustomException(ExceptionErrorCode.LOGIN_ERROR_MESSAGE));
        if(!passwordEncoder.matches(pw, findedUserService.getPw())) {
            throw new RuntimeException("비밀번호 불일치");
        }
        return new ResponseUserDto(findedUserService);
    }
}
