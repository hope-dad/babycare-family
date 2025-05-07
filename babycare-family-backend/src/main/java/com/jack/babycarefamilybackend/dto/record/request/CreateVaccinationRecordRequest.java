package com.jack.babycarefamilybackend.dto.record.request;

public record CreateVaccinationRecordRequest(
        Long babyId,
        Long userId,
        String vaccineName,
        LocalDateTime vaccinationDate,
        LocalDateTime nextVaccinationDate,
        String note
) {}
