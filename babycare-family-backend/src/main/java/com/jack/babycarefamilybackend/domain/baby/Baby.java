package com.jack.babycarefamilybackend.domain.baby;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "baby")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Baby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    private FamilyGroup familyGroup;

    public Baby(String name, LocalDate birthDate, String gender, FamilyGroup familyGroup) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.familyGroup = familyGroup;
    }
}
