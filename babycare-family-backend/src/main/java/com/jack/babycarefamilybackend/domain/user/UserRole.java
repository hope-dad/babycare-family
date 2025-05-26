package com.jack.babycarefamilybackend.domain.user;

import lombok.Getter;

@Getter
public enum UserRole {
    PARENT("부모"),
    GUARDIAN("보호자"),
    ADMIN("관리자");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }

}
