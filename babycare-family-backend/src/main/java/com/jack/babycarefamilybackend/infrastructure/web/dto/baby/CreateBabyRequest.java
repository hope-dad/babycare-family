package com.jack.babycarefamilybackend.infrastructure.web.dto.baby;

import com.jack.babycarefamilybackend.domain.baby.Gender;
import java.time.LocalDate;

public record CreateBabyRequest(
        String name,
        LocalDate birthDate,
        Gender gender,
        Long familyGroupId,
        String photoUrl,
        String bloodType,
        String characteristics,
        String allergies,
        String prenatalName
) {}
