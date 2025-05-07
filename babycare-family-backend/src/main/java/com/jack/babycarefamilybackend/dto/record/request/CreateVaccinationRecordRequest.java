package com.jack.babycarefamilybackend.dto.record.request;

import java.time.LocalDateTime;

public record CreateVaccinationRecordRequest(
        Long babyId,
        Long userId,
        String vaccineName,
        LocalDateTime vaccinationDate,
        LocalDateTime nextVaccinationDate,
        String note
) {}
