package com.jack.babycarefamilybackend.infrastructure.web.dto.record.request;


import java.time.LocalDateTime;

public record CreateHospitalVisitRecordRequest(
        Long babyId,
        Long userId,
        LocalDateTime visitDate,
        String hospitalName,
        String symptoms,
        String diagnosis,
        String prescribedMedication
) {}