package com.jack.babycarefamilybackend.application.checklist;

import com.jack.babycarefamilybackend.domain.checklist.Checklist;
import com.jack.babycarefamilybackend.domain.checklist.ChecklistRepository;
import com.jack.babycarefamilybackend.dto.checklist.ChecklistDto;
import com.jack.babycarefamilybackend.dto.checklist.CreateChecklistRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChecklistService {

    private final ChecklistRepository checklistRepository;
    private final ChecklistMapper checklistMapper;

    @Transactional
    public ChecklistDto create(CreateChecklistRequest request) {
        Checklist checklist = checklistMapper.toEntity(request);
        return checklistMapper.toDto(checklistRepository.save(checklist));
    }

    @Transactional(readOnly = true)
    public List<ChecklistDto> getByBaby(Long babyId) {
        return checklistRepository.findByBabyId(babyId)
                .stream()
                .map(checklistMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ChecklistDto> getByUser(Long userId) {
        return checklistRepository.findByUserId(userId)
                .stream()
                .map(checklistMapper::toDto)
                .toList();
    }

    @Transactional
    public void markCompleted(Long checklistId) {
        Checklist checklist = checklistRepository.findById(checklistId)
                .orElseThrow(() -> new IllegalArgumentException("Checklist not found"));
        checklist.markCompleted();
    }

    @Transactional
    public void markIncomplete(Long checklistId) {
        Checklist checklist = checklistRepository.findById(checklistId)
                .orElseThrow(() -> new IllegalArgumentException("Checklist not found"));
        checklist.markIncomplete();
    }
}
