package com.jack.babycarefamilybackend.domain.schedule;

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
@Table(name = "schedule")
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


    public static Schedule create(Baby baby, User user, String title, LocalDateTime startTime, LocalDateTime endTime, String description) {
        Schedule schedule = new Schedule();
        schedule.setBaby(baby);
        schedule.setUser(user);
        schedule.setTitle(title);
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        schedule.setDescription(description);
        schedule.setCreatedAt(LocalDateTime.now());
        return schedule;
    }
}
