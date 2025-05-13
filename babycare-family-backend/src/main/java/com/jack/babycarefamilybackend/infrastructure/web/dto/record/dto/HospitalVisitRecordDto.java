package com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto;


import java.time.LocalDateTime;

public record HospitalVisitRecordDto(
        Long id,
        Long babyId,
        Long userId,
        LocalDateTime visitDate,
        String hospitalName,
        String symptoms,
        String diagnosis,
        String prescribedMedication
) {}
