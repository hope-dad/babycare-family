package com.jack.babycarefamilybackend.application.usecase.comment;

import com.jack.babycarefamilybackend.infrastructure.web.dto.comment.CommentDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.comment.CreateCommentRequest;

import java.util.List;

public interface CommentService {
    CommentDto create(CreateCommentRequest request);

    List<CommentDto> findAll();
}
