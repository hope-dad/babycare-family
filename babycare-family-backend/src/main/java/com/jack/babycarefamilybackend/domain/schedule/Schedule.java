package com.jack.babycarefamilybackend.domain.schedule;

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
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
    private LocalDateTime createdAt;

    public Schedule(Baby baby, User user, String title, LocalDateTime startTime, LocalDateTime endTime, String description) {
        this.baby = baby;
        this.user = user;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }
}
