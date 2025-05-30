package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.enums.DiaperContentType;
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

    private DiaperContentType type;  // 소변/대변
    private String note;
    private LocalDateTime changedAt;

    public static DiaperRecord create(
            Baby baby,
            User user,
            DiaperContentType type,
            String note,
            LocalDateTime changedAt
    ) {
        DiaperRecord record = new DiaperRecord();
        record.baby = baby;
        record.user = user;
        record.type = type;
        record.note = note;
        record.changedAt = changedAt;
        return record;
    }
}
