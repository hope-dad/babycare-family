package com.jack.babycarefamilybackend.infrastructure.web.dto.record.request;

import java.time.LocalDateTime;

public record CreateDiaperRecordRequest(
        Long babyId,
        Long userId,
        String type,
        String note,
        LocalDateTime changedAt
) {}
