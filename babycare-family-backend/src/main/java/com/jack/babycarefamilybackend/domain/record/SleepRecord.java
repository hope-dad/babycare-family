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


    public SleepRecord(Baby baby1, User user1, LocalDateTime sleepStart, LocalDateTime sleepEnd, String note) {
        this.baby = baby1;
        this.user = user1;
        this.sleepStart = sleepStart;
        this.sleepEnd = sleepEnd;
        this.note = note;
    }
}