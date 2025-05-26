package com.jack.babycarefamilybackend.domain.checklist;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.common.BaseTimeEntity;
import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Table(name = "checklist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Checklist extends BaseTimeEntity {

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
        checklist.dueDate = dueDate;
        checklist.priority = priority;
        checklist.category = category;
        checklist.notes = notes;
        return checklist;
    }

    public void markIncomplete() {
        if (this.completed) {
            this.completed = false;
            this.completedAt = null;
        }
    }

    public void complete() {
        if (this.completed) {
            return;
        }
        this.completed = true;
        this.completedAt = LocalDateTime.now();
    }

    public void updateContent(@NotBlank String content) { // 파라미터 유효성 검사
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("체크리스트 내용은 필수입니다.");
        }
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
