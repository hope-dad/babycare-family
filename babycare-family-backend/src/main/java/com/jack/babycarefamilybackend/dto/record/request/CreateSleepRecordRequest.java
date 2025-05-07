package com.jack.babycarefamilybackend.dto.record.request;

import java.time.LocalDateTime;

public record CreateSleepRecordRequest(
        Long babyId,
        Long userId,
        LocalDateTime sleepStart,
        LocalDateTime sleepEnd,
        String note
) {}