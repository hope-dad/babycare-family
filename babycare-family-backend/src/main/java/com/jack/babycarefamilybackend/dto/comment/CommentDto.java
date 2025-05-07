package com.jack.babycarefamilybackend.dto.comment;

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