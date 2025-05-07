package com.jack.babycarefamilybackend.domain.commant;

import com.jack.babycarefamilybackend.domain.record.babyrecord.BabyRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "baby_record_id")
    private BabyRecord babyRecord;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(String text, BabyRecord babyRecord, User user) {
        this.text = text;
        this.babyRecord = babyRecord;
        this.user = user;
    }
}
