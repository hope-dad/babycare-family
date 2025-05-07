package com.jack.babycarefamilybackend.dto.record.request;

import java.time.LocalDate;

public record CreateMilestoneRecordRequest(
        Long babyId,
        Long userId,
        String eventName,
        LocalDate date,
        String note,
        String photoUrl
) {}
