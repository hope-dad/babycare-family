package com.jack.babycarefamilybackend.dto.comment;

public record CreateCommentRequest(
        Long userId,
        String content,
        String recordType,
        Long recordId,
        Long babyId
) {}