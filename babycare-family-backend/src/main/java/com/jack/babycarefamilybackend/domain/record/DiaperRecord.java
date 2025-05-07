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
@Table(name = "diaper_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaperRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String type;  // 소변/대변
    private String note;
    private LocalDateTime changedAt;

    public DiaperRecord(Baby baby, User user, String type, String note, LocalDateTime changedAt) {
        this.baby = baby;
        this.user = user;
        this.type = type;
        this.note = note;
        this.changedAt = changedAt;
    }
}
