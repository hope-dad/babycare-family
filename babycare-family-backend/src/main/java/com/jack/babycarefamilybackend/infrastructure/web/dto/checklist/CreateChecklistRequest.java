package com.jack.babycarefamilybackend.infrastructure.web.dto.checklist;

import java.time.LocalDate;

public record CreateChecklistRequest(
        Long babyId,
        Long userId,
        String content,
        LocalDate dueDate,
        Integer priority,
        String category,
        String notes
) {}
