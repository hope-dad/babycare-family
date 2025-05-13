package com.jack.babycarefamilybackend.infrastructure.web.dto.record.request;

import java.time.LocalDateTime;

public record CreateFeedingRecordRequest(
        Long babyId,
        Long userId,
        String type,
        Double amount,
        LocalDateTime fedAt
) {}
