package com.jack.babycarefamilybackend.infrastructure.web.dto.user;

import com.jack.babycarefamilybackend.domain.user.UserRole;

public record CreateUserRequest(
        String name,
        String email,
        UserRole role,
        Long familyGroupId
) {}