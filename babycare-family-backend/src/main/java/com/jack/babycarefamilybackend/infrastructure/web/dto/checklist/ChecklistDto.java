package com.jack.babycarefamilybackend.infrastructure.web.dto.checklist;


import java.time.LocalDate;
import java.time.LocalDateTime;

public record ChecklistDto(
        Long id,
        Long babyId,
        Long userId,
        String content,
        boolean completed,
        LocalDateTime createdAt,
        LocalDateTime completedAt,
        LocalDate dueDate,
        Integer priority,
        String category,
        String notes
) {}