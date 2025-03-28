package com.example.schedule.controller;

import com.example.schedule.dto.RequestUserDto;
import com.example.schedule.dto.ResponseUserDto;
import com.example.schedule.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseUserDto> postUser(@RequestBody RequestUserDto requestUserDto) {
        ResponseUserDto a = userService.postUserService(requestUserDto);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> getAllUser() {
        List<ResponseUserDto> a = userService.getAllUserService();
        return new ResponseEntity<List<ResponseUserDto>>(a, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> getIdUser(@PathVariable Long id) {
        ResponseUserDto a = userService.getIdUserService(id);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDto> putIdUser(@PathVariable Long id, @RequestBody RequestUserDto requestUserDto) {
        ResponseUserDto a = userService.updateUser(id, requestUserDto);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIdUser(@PathVariable Long id, @RequestBody RequestUserDto requestUserDto) {
        userService.deleteUser(id, requestUserDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
