package com.jack.babycarefamilybackend.dto.checklist;

public record CreateChecklistRequest(
        Long babyId,
        Long userId,
        String content
) {}
