package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "illness_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IllnessRecord {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private Baby baby;

    private String symptom;
    private LocalDate startDate;
    private LocalDate endDate;
    private String note;


    public IllnessRecord(Baby baby1, String symptom, LocalDate startDate, LocalDate endDate, String note) {
        this.baby = baby1;
        this.symptom = symptom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
    }
}
