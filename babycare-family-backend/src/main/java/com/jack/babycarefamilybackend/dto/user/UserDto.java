package com.jack.babycarefamilybackend.dto.user;

import com.jack.babycarefamilybackend.domain.user.UserRole;

public record UserDto(
        Long id,
        String name,
        String email,
        UserRole role,
        Long familyGroupId
) {}

