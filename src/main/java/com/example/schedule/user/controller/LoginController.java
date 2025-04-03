package com.example.schedule.user.controller;

import com.example.schedule.user.dto.ResponseUserDto;
import com.example.schedule.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Email;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registry")
@Validated

public class LoginController {

    private final UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 회원가입 해주기
     * @param email
     * @param pw
     * @return
     */

    @PostMapping("/signup")
    public ResponseEntity<ResponseUserDto> signUpUser(@RequestParam @Email String email, @RequestParam String pw) {
        ResponseUserDto madeUser = userService.saveUser(email, pw);
        return new ResponseEntity<>(madeUser, HttpStatus.CREATED);
    }

    /**
     * 로그인 하기
     * @param email
     * @param pw
     * @param httpServletRequest
     * @return
     */

    @PostMapping("/login")
    public ResponseEntity<ResponseUserDto> loginUpUser(@RequestParam @Email String email, @RequestParam String pw, HttpServletRequest httpServletRequest) {
        ResponseUserDto findedUser = userService.findUser(email, pw);
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("User",findedUser);
        return new ResponseEntity<>(findedUser, HttpStatus.CREATED);
    }
}
