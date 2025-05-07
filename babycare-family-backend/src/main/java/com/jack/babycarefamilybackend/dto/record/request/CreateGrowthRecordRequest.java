package com.jack.babycarefamilybackend.dto.record.request;

import java.time.LocalDateTime;

public record CreateGrowthRecordRequest(
        Long babyId,
        Long userId,
        Double height,
        Double weight,
        Double headCircumference,
        LocalDateTime recordedAt,
        String note
) {}