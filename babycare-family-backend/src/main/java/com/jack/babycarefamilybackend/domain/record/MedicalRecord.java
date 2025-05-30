package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "medical_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MedicalRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String diagnosis;
    private String treatment;
    private String prescribedMedication;
    private LocalDateTime visitDate;
    private String doctorName;
    private String note;

    public static MedicalRecord create(
            Baby baby,
            User user,
            String diagnosis,
            String treatment,
            String prescribedMedication,
            LocalDateTime visitDate,
            String doctorName,
            String note
    ) {
        MedicalRecord record = new MedicalRecord();
        record.baby = baby;
        record.user = user;
        record.diagnosis = diagnosis;
        record.treatment = treatment;
        record.prescribedMedication = prescribedMedication;
        record.visitDate = visitDate;
        record.doctorName = doctorName;
        record.note = note;
        return record;
    }
}
