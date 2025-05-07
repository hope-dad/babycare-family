package com.jack.babycarefamilybackend.dto.familygroup;

import java.time.LocalDateTime;

public record FamilyGroupDto(
        Long id,
        String name,
        LocalDateTime createdAt
) {}