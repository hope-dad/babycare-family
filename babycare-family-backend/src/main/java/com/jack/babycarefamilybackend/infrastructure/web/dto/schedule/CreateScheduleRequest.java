package com.jack.babycarefamilybackend.infrastructure.web.dto.schedule;

import java.time.LocalDateTime;

public record CreateScheduleRequest(
        Long babyId,
        Long userId,
        String title,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String description
) {}
