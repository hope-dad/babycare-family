package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
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

    public static MilestoneRecord create(Baby baby, User user, String eventName, LocalDate date, String note, String photoUrl) {
        MilestoneRecord milestoneRecord = new MilestoneRecord();
        milestoneRecord.baby = baby;
        milestoneRecord.user = user;
        milestoneRecord.eventName = eventName;
        milestoneRecord.date = date;
        milestoneRecord.note = note;
        milestoneRecord.photoUrl = photoUrl;
        return milestoneRecord;
    }
}
