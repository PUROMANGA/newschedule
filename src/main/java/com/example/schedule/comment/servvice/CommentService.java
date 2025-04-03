package com.example.schedule.comment.servvice;

import com.example.schedule.comment.dto.RequestCommentDto;
import com.example.schedule.comment.dto.ResponseCommentDto;
import com.example.schedule.comment.entity.Comment;
import com.example.schedule.comment.repository.CommentRepository;
import com.example.schedule.exception.CustomException;
import com.example.schedule.exception.ExceptionErrorCode;
import org.springframework.stereotype.Service;

@Service

public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * 댓글 작성하고 저장된 댓글을 반환합니다.
     * @param requestCommentDto  입력된 댓글
     * @return #requestCommentDto 입력된 댓글
     */
    public ResponseCommentDto postComment(RequestCommentDto requestCommentDto) {
        return new ResponseCommentDto(commentRepository.save(new Comment(requestCommentDto)));
    }

    /**
     * 특정 댓글 id를 받아서 찾아줍니다.
     * @param id 입력된 댓글 id
     * @return id로 찾은 comment
     */

    public ResponseCommentDto getCommentService(Long id) {
        Comment getComment = commentRepository
                .findById(id)
                .orElseThrow(() -> new CustomException(ExceptionErrorCode.FINDID_ERROR_MESSAGE));

        return new ResponseCommentDto(getComment);
    }

    /**
     * 댓글 id로 댓글을 찾아서, 입력된 댓글로 수정해줍니다.
     * @param id 입력된 댓글 id
     * @param requestCommentDto 입력된 댓글
     * @return 입력된 댓글
     */

    public ResponseCommentDto updateCommentService(Long id, RequestCommentDto requestCommentDto) {
        Comment getComment = commentRepository
                .findById(id)
                .orElseThrow(() -> new CustomException(ExceptionErrorCode.FINDID_ERROR_MESSAGE));
        getComment.update(requestCommentDto);
        return new ResponseCommentDto(commentRepository.save(getComment));
    }

    /**
     * 댓글 id로 특정 댓글을 조회해서 삭제해줍니다.
     * @param id 입력된 댓글 id
     */

    public void deleteCommentService(Long id) {
        Comment getComment = commentRepository
                .findById(id)
                .orElseThrow(() -> new CustomException(ExceptionErrorCode.FINDID_ERROR_MESSAGE));
        commentRepository.delete(getComment);
    }
}
