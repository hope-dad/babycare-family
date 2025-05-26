package com.jack.babycarefamilybackend.infrastructure.web.dto.record.request;

import com.jack.babycarefamilybackend.domain.record.enums.FeedingType;

import java.time.LocalDateTime;

public record CreateFeedingRecordRequest(
        Long babyId,
        Long userId,
        FeedingType type,
        Double amount,
        LocalDateTime fedAt
) {}
