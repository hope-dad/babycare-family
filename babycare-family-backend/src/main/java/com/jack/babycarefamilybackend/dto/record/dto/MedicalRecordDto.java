package com.jack.babycarefamilybackend.dto.record.dto;

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