package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "baby_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BabyRecord {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static BabyRecord create(String content, User user) {
        BabyRecord babyRecord = new BabyRecord();
        babyRecord.content = content;
        babyRecord.user = user;
        return babyRecord;
    }
}