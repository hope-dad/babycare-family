package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SleepRecord {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime sleepStart;
    private LocalDateTime sleepEnd;
    private String note;


    public static SleepRecord create(Baby baby, User user, LocalDateTime sleepStart, LocalDateTime sleepEnd, String note) {
        SleepRecord record = new SleepRecord();
        record.baby = baby;
        record.user = user;
        record.sleepStart = sleepStart;
        record.sleepEnd = sleepEnd;
        record.note = note;
        return record;
    }
}