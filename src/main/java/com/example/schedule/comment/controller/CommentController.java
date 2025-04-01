package com.example.schedule.comment.controller;


import com.example.schedule.comment.dto.RequestCommentDto;
import com.example.schedule.comment.dto.ResponseCommentDto;
import com.example.schedule.comment.servvice.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<ResponseCommentDto> postComment(@RequestBody RequestCommentDto requestCommentDto) {
        return new ResponseEntity<>(
                commentService.postComment(requestCommentDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCommentDto> getComment(@PathVariable Long id) {
        ResponseCommentDto a = commentService.getCommentService(id);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCommentDto> putComment(@PathVariable Long id, @RequestBody RequestCommentDto requestCommentDto) {
        ResponseCommentDto a = commentService.updateCommentService(id, requestCommentDto);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteCommentService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
