package com.jack.babycarefamilybackend.dto.record.request;

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
