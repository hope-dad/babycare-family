package com.jack.babycarefamilybackend.domain.baby;

import com.jack.babycarefamilybackend.domain.common.BaseTimeEntity;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "baby")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Baby extends BaseTimeEntity {

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_group_id", nullable = false)
    private FamilyGroup familyGroup;

    @Column(length = 500)
    private String photoUrl;

    @Column(length = 5)
    private String bloodType;

    @Column(length = 1000)
    private String characteristics;

    @Column(length = 500)
    private String allergies;

    @Column(length = 50)
    private String prenatalName;

    @Column(nullable = false)
    private boolean active = true;

    private Instant deletedAt;

    public static Baby create(String name, LocalDate birthDate, Gender gender, FamilyGroup familyGroup,
                              String photoUrl, String bloodType, String characteristics, String allergies,
                              String prenatalName) {
        Baby baby = new Baby();
        baby.name = name;
        baby.birthDate = birthDate;
        baby.gender = gender;
        baby.familyGroup = familyGroup;
        baby.photoUrl = photoUrl;
        baby.bloodType = bloodType;
        baby.characteristics = characteristics;
        baby.allergies = allergies;
        baby.prenatalName = prenatalName;
        return baby;
    }

    public void softDelete() {
        this.active = false;
        this.deletedAt = Instant.now();
    }

    public void updateBabyInfo(
            String name,
            LocalDate birthDate,
            Gender gender,
            FamilyGroup familyGroup,
            String photoUrl,
            String bloodType,
            String characteristics,
            String allergies,
            String prenatalName
    ) {
        if (name != null) this.name = name;
        if (birthDate != null) this.birthDate = birthDate;
        if (gender != null) this.gender = gender;
        if (familyGroup != null) this.familyGroup = familyGroup;
        if (photoUrl != null) this.photoUrl = photoUrl;
        if (bloodType != null) this.bloodType = bloodType;
        if (characteristics != null) this.characteristics = characteristics;
        if (allergies != null) this.allergies = allergies;
        if (prenatalName != null) this.prenatalName = prenatalName;
    }


}
