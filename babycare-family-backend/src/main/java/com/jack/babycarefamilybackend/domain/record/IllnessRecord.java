package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
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

    public IllnessRecord(Baby baby, String symptom, LocalDate startDate, LocalDate endDate, String note) {
        this.baby = baby;
        this.symptom = symptom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
    }
}
