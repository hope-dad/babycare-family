package com.jack.babycarefamilybackend.domain.familygroup;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "family_group")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FamilyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;  // 가족 그룹 이름

    public FamilyGroup(String name) {
        this.name = name;
    }
}
