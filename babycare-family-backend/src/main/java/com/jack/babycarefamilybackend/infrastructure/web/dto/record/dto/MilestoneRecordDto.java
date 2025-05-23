package com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto;

import java.time.LocalDate;

public record MilestoneRecordDto(
        Long id,
        Long babyId,
        Long userId,
        String eventName,
        LocalDate date,
        String note,
        String photoUrl
) {}
