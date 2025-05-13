package com.jack.babycarefamilybackend.infrastructure.web.dto.record.request;

import java.time.LocalDateTime;

public record CreateMedicalRecordRequest(
        Long babyId,
        Long userId,
        String diagnosis,
        String treatment,
        String prescribedMedication,
        LocalDateTime visitDate,
        String doctorName,
        String note
) {}
