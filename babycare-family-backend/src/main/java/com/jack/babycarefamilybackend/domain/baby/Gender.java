package com.jack.babycarefamilybackend.domain.baby;

public enum Gender {
    MALE, FEMALE;

    public static Gender from(String value) {
        if (value == null || value.isBlank()) return null;
        try {
            return Gender.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid gender value: " + value);
        }
    }
}
