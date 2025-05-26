package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.enums.FeedingType;
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
@Table(name = "feeding_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private FeedingType type;  // 모유/분유
    private Double amount;  // ml
    private LocalDateTime fedAt;

    public static FeedingRecord create(Baby baby, User user, FeedingType type, Double amount, LocalDateTime fedAt) {
        FeedingRecord feedingRecord = new FeedingRecord();
        feedingRecord.baby = baby;
        feedingRecord.user = user;
        feedingRecord.type = type;
        feedingRecord.amount = amount;
        feedingRecord.fedAt = fedAt;
        return feedingRecord;
    }
}
