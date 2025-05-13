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


    public GrowthRecord(Baby baby1, User user1, Double height, Double weight, Double headCircumference, LocalDateTime recordedAt, String note) {
        this.baby = baby1;
        this.user = user1;
        this.height = height;
        this.weight = weight;
        this.headCircumference = headCircumference;
        this.recordedAt = recordedAt;
        this.note = note;
    }
}
