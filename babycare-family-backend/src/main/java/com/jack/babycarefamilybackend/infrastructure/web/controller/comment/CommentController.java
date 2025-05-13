package com.jack.babycarefamilybackend.infrastructure.web.controller.comment;

import com.jack.babycarefamilybackend.application.usecase.comment.CommentService;
import com.jack.babycarefamilybackend.infrastructure.web.dto.comment.CommentDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.comment.CreateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDto> create(@RequestBody CreateCommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getAll() {
        return ResponseEntity.ok(commentService.findAll());
    }
}
