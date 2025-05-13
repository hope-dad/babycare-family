package com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto;

import java.time.LocalDate;

public record IllnessRecordDto(
        Long id,
        Long babyId,
        String symptom,
        LocalDate startDate,
        LocalDate endDate,
        String note
) {}
