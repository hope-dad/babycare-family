package com.jack.babycarefamilybackend.dto.feedingrecord;

import java.time.LocalDateTime;

public record CreateFeedingRecordRequest(
        String type,
        Double amount,
        LocalDateTime fedAt,
        Long userId
) {}
