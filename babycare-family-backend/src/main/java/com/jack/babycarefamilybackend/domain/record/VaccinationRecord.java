package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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


    public static VaccinationRecord create(Baby baby, User user, String vaccineName, LocalDateTime vaccinationDate, LocalDateTime nextVaccinationDate, String note) {
        VaccinationRecord record = new VaccinationRecord();
        record.baby = baby;
        record.user = user;
        record.vaccineName = vaccineName;
        record.vaccinationDate = vaccinationDate;
        record.nextVaccinationDate = nextVaccinationDate;
        record.note = note;
        return record;
    }
}