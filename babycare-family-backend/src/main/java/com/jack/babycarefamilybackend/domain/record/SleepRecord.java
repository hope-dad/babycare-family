package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
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

    public SleepRecord(Baby baby, User user, LocalDateTime sleepStart, LocalDateTime sleepEnd, String note) {
        this.baby = baby;
        this.user = user;
        this.sleepStart = sleepStart;
        this.sleepEnd = sleepEnd;
        this.note = note;
    }
}