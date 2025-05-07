package com.jack.babycarefamilybackend.dto.record.dto;

import java.time.LocalDateTime;

public record SleepRecordDto(
        Long id,
        Long babyId,
        Long userId,
        LocalDateTime sleepStart,
        LocalDateTime sleepEnd,
        String note
) {}
