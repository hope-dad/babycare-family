package com.jack.babycarefamilybackend.infrastructure.web.dto.record.request;

import java.time.LocalDate;

public record CreateIllnessRecordRequest(
        Long babyId,
        String symptom,
        LocalDate startDate,
        LocalDate endDate,
        String note
) {}
