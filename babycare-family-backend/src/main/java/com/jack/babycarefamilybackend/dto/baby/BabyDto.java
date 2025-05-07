package com.jack.babycarefamilybackend.dto.baby;

import java.time.LocalDate;

public record BabyDto(
        Long id,
        String name,
        LocalDate birthDate,
        String gender,
        Long familyGroupId
) {}
