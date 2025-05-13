package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

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

    public MedicalRecord(Baby baby1, User user1, String diagnosis, String treatment, String prescribedMedication, LocalDateTime visitDate, String doctorName, String note) {
        this.baby = baby1;
        this.user = user1;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.prescribedMedication = prescribedMedication;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.note = note;
    }
}
