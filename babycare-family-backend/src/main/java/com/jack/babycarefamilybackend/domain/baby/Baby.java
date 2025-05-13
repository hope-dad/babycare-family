package com.jack.babycarefamilybackend.domain.baby;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "baby")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Baby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Past
    @Column(nullable = false)
    private LocalDate birthDate;

    @NotNull
    @Column(nullable = false)
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_group_id", nullable = false)
    private FamilyGroup familyGroup;

    @Column(length = 500)
    private String photoUrl;

    @Column(length = 3)
    private String bloodType;

    @Column(length = 1000)
    private String characteristics;

    @Column(length = 500)
    private String allergies;

    @Column(length = 50)
    private String prenatalName;

    public Baby(String name, LocalDate birthDate, String gender, FamilyGroup familyGroup,
                String photoUrl, String bloodType, String characteristics, String allergies,
                String prenatalName) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.familyGroup = familyGroup;
        this.photoUrl = photoUrl;
        this.bloodType = bloodType;
        this.characteristics = characteristics;
        this.allergies = allergies;
        this.prenatalName = prenatalName;
    }

    public void updateBabyInfo(String name, LocalDate birthDate, String gender, FamilyGroup familyGroup) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.familyGroup = familyGroup;
    }

}


