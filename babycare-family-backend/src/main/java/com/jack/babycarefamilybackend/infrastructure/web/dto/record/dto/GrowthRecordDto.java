package com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto;

import java.time.LocalDateTime;

public record GrowthRecordDto(
        Long id,
        Long babyId,
        Long userId,
        Double height,   // cm
        Double weight,   // kg
        Double headCircumference,   // cm
        LocalDateTime recordedAt,
        String note
) {}
