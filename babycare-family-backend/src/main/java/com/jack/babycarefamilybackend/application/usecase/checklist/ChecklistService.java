package com.jack.babycarefamilybackend.application.usecase.checklist;

import com.jack.babycarefamilybackend.infrastructure.web.dto.checklist.ChecklistDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.checklist.CreateChecklistRequest;

import java.util.List;


public interface ChecklistService {
    ChecklistDto create(CreateChecklistRequest request);

    List<ChecklistDto> getByBaby(Long babyId);

    List<ChecklistDto> getByUser(Long userId);

    void markCompleted(Long checklistId);

    void markIncomplete(Long checklistId);
}

