package com.jack.babycarefamilybackend.infrastructure.web.dto.comment;

import java.time.LocalDateTime;

public record CommentDto(
        Long id,
        String content,
        String recordType,
        Long recordId,
        Long babyId,
        Long userId,
        LocalDateTime createdAt
) {}