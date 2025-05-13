package com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto;

import java.time.LocalDateTime;

public record FeedingRecordDto(
        Long id,
        Long babyId,
        Long userId,
        String type,   // 모유, 분유 등
        Double amount, // ml 단위
        LocalDateTime fedAt
) {}
