package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "milestone_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MilestoneRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String eventName;
    private LocalDate date;
    private String note;
    private String photoUrl;

    public MilestoneRecord(Baby baby, User user, String eventName, LocalDate date, String note, String photoUrl) {
        this.baby = baby;
        this.user = user;
        this.eventName = eventName;
        this.date = date;
        this.note = note;
        this.photoUrl = photoUrl;
    }
}
