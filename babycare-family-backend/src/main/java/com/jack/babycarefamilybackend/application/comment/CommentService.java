package com.jack.babycarefamilybackend.application.comment;

import com.jack.babycarefamilybackend.domain.commant.Comment;
import com.jack.babycarefamilybackend.domain.commant.CommentRepository;
import com.jack.babycarefamilybackend.dto.comment.CommentDto;
import com.jack.babycarefamilybackend.dto.comment.CreateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentDto create(CreateCommentRequest request) {
        Comment comment = commentMapper.toEntity(request);
        return commentMapper.toDto(commentRepository.save(comment));
    }

    public List<CommentDto> findAll() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toDto)
                .toList();
    }
}
