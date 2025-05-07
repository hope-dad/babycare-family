package com.jack.babycarefamilybackend.dto.schedule;

import java.time.LocalDateTime;

public record CreateScheduleRequest(
        Long babyId,
        Long userId,
        String title,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String description
) {}
