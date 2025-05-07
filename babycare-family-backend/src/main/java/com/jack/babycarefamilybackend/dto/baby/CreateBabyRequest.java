package com.jack.babycarefamilybackend.dto.baby;

import java.time.LocalDate;

public record CreateBabyRequest(
        String name,
        LocalDate birthDate,
        String gender,
        Long familyGroupId
) {}
