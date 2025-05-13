package com.jack.babycarefamilybackend.domain.user;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "user")
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

    public static User create(String name, String email, UserRole role, FamilyGroup familyGroup) {
        User user = new User();
        user.name = name;
        user.email = email;
        user.role = role;
        user.familyGroup = familyGroup;
        return user;
    }
}
