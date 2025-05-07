package com.jack.babycarefamilybackend.domain.commant;

import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String recordType;  // "FEEDING", "DIAPER", "SLEEP", etc.

    private Long recordId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private LocalDateTime createdAt;

    public Comment(String content, String recordType, Long recordId, User user) {
        this.content = content;
        this.recordType = recordType;
        this.recordId = recordId;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }
}
