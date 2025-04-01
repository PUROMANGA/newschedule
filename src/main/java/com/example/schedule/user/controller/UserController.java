package com.example.schedule.user.controller;

import com.example.schedule.user.dto.RequestUserDto;
import com.example.schedule.user.dto.ResponseUserDto;
import com.example.schedule.user.service.UserService;
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

    @PostMapping
    public ResponseEntity<ResponseUserDto> postUser(@RequestBody RequestUserDto requestUserDto) {
        return new ResponseEntity<>(userService.postUserService(requestUserDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUserService(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> getIdUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getIdUserService(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDto> putIdUser(@PathVariable Long id, @RequestBody RequestUserDto requestUserDto) {
        return new ResponseEntity<>(userService.updateUser(id, requestUserDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIdUser(@PathVariable Long id, @RequestBody RequestUserDto requestUserDto) {
        userService.deleteUser(id, requestUserDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
