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
@Table(name = "growth_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GrowthRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Double height;
    private Double weight;
    private Double headCircumference;
    private LocalDateTime recordedAt;
    private String note;


    public static GrowthRecord create(Baby baby, User user, Double height, Double weight, Double headCircumference, LocalDateTime recordedAt, String note) {
        GrowthRecord growthRecord = new GrowthRecord();
        growthRecord.setBaby(baby);
        growthRecord.setUser(user);
        growthRecord.setHeight(height);
        growthRecord.setWeight(weight);
        growthRecord.setHeadCircumference(headCircumference);
        growthRecord.setRecordedAt(recordedAt);
        growthRecord.setNote(note);
        return growthRecord;
    }
}
