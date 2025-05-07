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

    // 새롭게 추가된 필드들! ✨
    private String photoUrl; // 아기 사진 URL
    private String bloodType; // 혈액형
    private String characteristics; // 특징이나 기타 정보
    private String allergies; // 알레르기 정보
    private String prenatalName; // 태명

    // 생성자도 추가된 필드들을 포함하도록 업데이트!
    public Baby(String name, LocalDate birthDate, String gender, FamilyGroup familyGroup,
                String photoUrl, String bloodType, String characteristics, String allergies, String prenatalName) {
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
}
