package com.jack.babycarefamilybackend.domain.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "feeding_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String type;  // 모유/분유
    private Double amount;  // ml
    private LocalDateTime fedAt;

    public FeedingRecord(Baby baby1, User user1, String type, Double amount, LocalDateTime fedAt) {
        this.baby = baby1;
        this.user = user1;
        this.type = type;
        this.amount = amount;
        this.fedAt = fedAt;
    }
}
