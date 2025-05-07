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
@Table(name="comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String recordType;  // "FEEDING", "DIAPER", "SLEEP", etc.

    private Long recordId; // 해당 recordType에 속한 엔티티의 ID

    private Long babyId;   // 해당 기록이 속한 아기 ID

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private LocalDateTime createdAt;

    public Comment(String content, String recordType, Long recordId, Long babyId, User user) {
        this.content = content;
        this.recordType = recordType;
        this.recordId = recordId;
        this.babyId = babyId;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }
}
