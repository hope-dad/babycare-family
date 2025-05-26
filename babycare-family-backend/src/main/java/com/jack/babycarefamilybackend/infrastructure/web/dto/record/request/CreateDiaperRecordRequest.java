package com.jack.babycarefamilybackend.infrastructure.web.dto.record.request;

import com.jack.babycarefamilybackend.domain.record.enums.DiaperContentType;

import java.time.LocalDateTime;

public record CreateDiaperRecordRequest(
        Long babyId,
        Long userId,
        DiaperContentType type,
        String note,
        LocalDateTime changedAt
) {}
