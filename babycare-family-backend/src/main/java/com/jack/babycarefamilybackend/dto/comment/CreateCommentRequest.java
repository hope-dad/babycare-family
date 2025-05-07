package com.jack.babycarefamilybackend.dto.comment;

public record CreateCommentRequest(String text, Long babyRecordId, Long userId) {}
