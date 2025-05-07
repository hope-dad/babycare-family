package com.jack.babycarefamilybackend.dto.comment;

public record CommentDto(Long id, String text, Long babyRecordId, Long userId) {}
