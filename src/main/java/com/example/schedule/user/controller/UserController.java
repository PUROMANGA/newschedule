package com.example.schedule.user.controller;

import com.example.schedule.user.dto.RequestUserDto;
import com.example.schedule.user.dto.ResponseUserDto;
import com.example.schedule.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 유저 등록
     * @param requestUserDto
     * @return
     */

    @PostMapping
    public ResponseEntity<ResponseUserDto> postUser(@RequestBody @Valid RequestUserDto requestUserDto) {
        return new ResponseEntity<>(userService.postUserService(requestUserDto), HttpStatus.CREATED);
    }

    /**
     * 유저 조회
     * @return
     */

    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUserService(), HttpStatus.OK);
    }

    /**
     * 특정 유저 조회
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> getIdUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getIdUserService(id), HttpStatus.OK);
    }

    /**
     * 유저 수정(유저 수정이란 말 자체가 좀 별로 안 좋아하지만 아무튼)
     * @param id
     * @param requestUserDto
     * @return
     */

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDto> putIdUser(@PathVariable Long id, @RequestBody @Valid RequestUserDto requestUserDto) {
        return new ResponseEntity<>(userService.updateUser(id, requestUserDto), HttpStatus.OK);
    }

    /**
     * 유저 삭제
     * @param id
     * @param requestUserDto
     * @return
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIdUser(@PathVariable Long id, @RequestBody @Valid RequestUserDto requestUserDto) {
        userService.deleteUser(id, requestUserDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
