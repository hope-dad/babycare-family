package com.jack.babycarefamilybackend.domain.user;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    private FamilyGroup familyGroup;

    public User(String name, String email, UserRole role, FamilyGroup familyGroup) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.familyGroup = familyGroup;
    }
}
