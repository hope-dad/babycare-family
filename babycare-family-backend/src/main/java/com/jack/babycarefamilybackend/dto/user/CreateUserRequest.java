package com.jack.babycarefamilybackend.dto.user;

import com.jack.babycarefamilybackend.domain.user.UserRole;

public record CreateUserRequest(
        String name,
        String email,
        UserRole role,
        Long familyGroupId
) {}