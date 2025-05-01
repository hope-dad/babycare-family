package com.jack.babycarefamilybackend.domain.user;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    @ManyToOne
    @JoinColumn(name = "family_group_id")
    private FamilyGroup familyGroup;

    public User(String nickname, FamilyGroup familyGroup) {
        this.nickname = nickname;
        this.familyGroup = familyGroup;
    }
}
