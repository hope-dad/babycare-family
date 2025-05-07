package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "vaccination_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VaccinationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String vaccineName;
    private LocalDateTime vaccinationDate;
    private LocalDateTime nextVaccinationDate;
    private String note;

    public VaccinationRecord(Baby baby, User user, String vaccineName, LocalDateTime vaccinationDate, LocalDateTime nextVaccinationDate, String note) {
        this.baby = baby;
        this.user = user;
        this.vaccineName = vaccineName;
        this.vaccinationDate = vaccinationDate;
        this.nextVaccinationDate = nextVaccinationDate;
        this.note = note;
    }
}