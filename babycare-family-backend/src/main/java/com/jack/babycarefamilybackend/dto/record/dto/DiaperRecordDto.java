package com.jack.babycarefamilybackend.dto.record.dto;

import java.time.LocalDateTime;

public record DiaperRecordDto(
        Long id,
        Long babyId,
        Long userId,
        String type,   // 소변, 대변
        String note,
        LocalDateTime changedAt
) {}
