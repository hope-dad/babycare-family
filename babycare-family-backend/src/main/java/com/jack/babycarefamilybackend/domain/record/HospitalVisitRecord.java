package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "hospital_visit_record")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HospitalVisitRecord {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime visitDate;
    private String hospitalName;
    private String symptoms;
    private String diagnosis;
    private String prescribedMedication;

    public HospitalVisitRecord(Baby baby1, User user1, LocalDateTime visitDate, String hospitalName, String symptoms, String diagnosis, String prescribedMedication) {
        this.baby = baby1;
        this.user = user1;
        this.visitDate = visitDate;
        this.hospitalName = hospitalName;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.prescribedMedication = prescribedMedication;
    }
}
