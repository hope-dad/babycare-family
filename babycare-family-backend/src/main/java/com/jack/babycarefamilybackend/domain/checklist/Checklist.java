package com.jack.babycarefamilybackend.domain.checklist;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Table(name = "checklist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private Baby baby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String content;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    private LocalDate dueDate;
    private Integer priority;
    private String category;
    private String notes;


    public static Checklist create(Baby baby, User user, String content,
                                   LocalDate dueDate, Integer priority,
                                   String category, String notes) {
        Checklist checklist = new Checklist();
        checklist.baby = baby;
        checklist.user = user;
        checklist.content = content;
        checklist.completed = false;
        checklist.createdAt = LocalDateTime.now();
        checklist.dueDate = dueDate;
        checklist.priority = priority;
        checklist.category = category;
        checklist.notes = notes;
        return checklist;
    }

    public void markIncomplete() {
        if (this.completed) { // 이미 완료 상태일 때만 처리
            this.completed = false;
            this.completedAt = null; // 완료 시각 초기화
        }
    }
    // 비즈니스 메서드
    public void complete() {
        this.completed = true;
        this.completedAt = LocalDateTime.now();
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void updatePriority(Integer priority) {
        this.priority = priority;
    }

    public void updateCategory(String category) {
        this.category = category;
    }

    public void updateNotes(String notes) {
        this.notes = notes;
    }
}
