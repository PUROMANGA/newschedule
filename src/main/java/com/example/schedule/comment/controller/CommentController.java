package com.example.schedule.comment.controller;


import com.example.schedule.comment.dto.RequestCommentDto;
import com.example.schedule.comment.dto.ResponseCommentDto;
import com.example.schedule.comment.servvice.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 코멘트 등록
     * @param requestCommentDto
     * @return
     */

    @PostMapping
    public ResponseEntity<ResponseCommentDto> postComment(@RequestBody @Valid RequestCommentDto requestCommentDto) {
        return new ResponseEntity<>(
                commentService.postComment(requestCommentDto),
                HttpStatus.CREATED);
    }

    /**
     * 특정 코멘트 찾기
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCommentDto> getComment(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.getCommentService(id), HttpStatus.OK);
    }

    /**
     * 코멘트 수정
     * @param id
     * @param requestCommentDto
     * @return
     */

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCommentDto> putComment(@PathVariable Long id, @RequestBody @Valid RequestCommentDto requestCommentDto) {
        return new ResponseEntity<>(commentService.updateCommentService(id, requestCommentDto), HttpStatus.OK);
    }

    /**
     * 코멘트 삭제
     * @param id
     * @return
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteCommentService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
