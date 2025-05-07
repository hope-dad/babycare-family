package com.jack.babycarefamilybackend.dto.checklist;


import java.time.LocalDate;
import java.time.LocalDateTime;

public record ChecklistDto(
        Long id,
        Long babyId,
        Long userId,
        String content,
        boolean isCompleted,
        LocalDateTime createdAt,
        LocalDateTime completedAt,
        LocalDate dueDate,
        Integer priority,
        String category,
        String notes
) {}