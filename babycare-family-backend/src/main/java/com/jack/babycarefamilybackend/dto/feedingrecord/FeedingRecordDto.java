package com.jack.babycarefamilybackend.dto.feedingrecord;

import java.time.LocalDateTime;

public record FeedingRecordDto(
        Long id,
        String type,
        Double amount,
        LocalDateTime fedAt,
        Long userId
) {}
