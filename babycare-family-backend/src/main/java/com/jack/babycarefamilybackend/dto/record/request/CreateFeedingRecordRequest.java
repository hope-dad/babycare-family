package com.jack.babycarefamilybackend.dto.record.request;

import java.time.LocalDateTime;

public record CreateFeedingRecordRequest(
        Long babyId,
        Long userId,
        String type,
        Double amount,
        LocalDateTime fedAt
) {}
