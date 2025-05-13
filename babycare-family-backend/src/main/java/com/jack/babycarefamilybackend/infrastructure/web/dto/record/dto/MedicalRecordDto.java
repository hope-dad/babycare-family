package com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto;

import java.time.LocalDateTime;

public record MedicalRecordDto(
        Long id,
        Long babyId,
        Long userId,
        String diagnosis,
        String treatment,
        String prescribedMedication,
        LocalDateTime visitDate,
        String doctorName,
        String note
) {}