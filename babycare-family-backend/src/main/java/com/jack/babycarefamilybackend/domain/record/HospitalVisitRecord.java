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

    public static HospitalVisitRecord create(
            Baby baby,
            User user,
            LocalDateTime visitDate,
            String hospitalName,
            String symptoms,
            String diagnosis,
            String prescribedMedication
    ) {
        HospitalVisitRecord record = new HospitalVisitRecord();
        record.baby = baby;
        record.user = user;
        record.visitDate = visitDate;
        record.hospitalName = hospitalName;
        record.symptoms = symptoms;
        record.diagnosis = diagnosis;
        record.prescribedMedication = prescribedMedication;
        return record;
    }
}
