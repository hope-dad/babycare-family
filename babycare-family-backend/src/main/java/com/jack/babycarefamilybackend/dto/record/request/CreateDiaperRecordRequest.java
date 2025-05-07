package com.jack.babycarefamilybackend.dto.record.request;

import java.time.LocalDateTime;

public record CreateDiaperRecordRequest(
        Long babyId,
        Long userId,
        String type,
        String note,
        LocalDateTime changedAt
) {}
