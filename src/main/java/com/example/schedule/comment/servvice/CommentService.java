package com.example.schedule.comment.servvice;

import com.example.schedule.comment.dto.RequestCommentDto;
import com.example.schedule.comment.dto.ResponseCommentDto;
import com.example.schedule.comment.entity.Comment;
import com.example.schedule.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ResponseCommentDto postComment(RequestCommentDto requestCommentDto) {
        return new ResponseCommentDto(commentRepository.save(new Comment(requestCommentDto)));
    }

    public ResponseCommentDto getCommentService(Long id) {
        Comment getComment = commentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 댓글이 존재하지 않습니다. ID: " + id));

        return new ResponseCommentDto(getComment);
    }

    public ResponseCommentDto updateCommentService(Long id, RequestCommentDto requestCommentDto) {
        Comment getComment = commentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 댓글이 존재하지 않습니다. ID: " + id));
        getComment.update(requestCommentDto);
        return new ResponseCommentDto(commentRepository.save(getComment));
    }

    public void deleteCommentService(Long id) {
        Comment getComment = commentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 댓글이 존재하지 않습니다. ID: " + id));
        commentRepository.delete(getComment);
    }
}
