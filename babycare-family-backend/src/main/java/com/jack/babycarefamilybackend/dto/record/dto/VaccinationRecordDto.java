package com.jack.babycarefamilybackend.dto.record.dto;


import java.time.LocalDateTime;

public record VaccinationRecordDto(
        Long id,
        Long babyId,
        Long userId,
        String vaccineName,
        LocalDateTime vaccinationDate,
        LocalDateTime nextVaccinationDate,
        String note
) {}
