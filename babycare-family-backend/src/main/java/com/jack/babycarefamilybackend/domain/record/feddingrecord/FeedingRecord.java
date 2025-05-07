package com.jack.babycarefamilybackend.domain.record.feddingrecord;

import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // 모유, 분유 등
    private Double amount; // ml 단위
    private LocalDateTime fedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public FeedingRecord(String type, Double amount, LocalDateTime fedAt, User user) {
        this.type = type;
        this.amount = amount;
        this.fedAt = fedAt;
        this.user = user;
    }
}
