package com.jack.babycarefamilybackend.application.usecase.checklist;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.checklist.Checklist;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.port.repository.ChecklistRepository;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.mapper.checklist.ChecklistMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.checklist.ChecklistDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.checklist.CreateChecklistRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChecklistServiceImpl implements ChecklistService {

    private final ChecklistMapper checklistMapper;
    private final BabyRepository babyRepository;
    private final UserRepository userRepository;
    private final ChecklistRepository checklistRepository;

    @Override
    @Transactional
    public ChecklistDto create(CreateChecklistRequest request) {
        Baby baby = findBaby(request.babyId());
        User user = findUser(request.userId());

        Checklist checklist = Checklist.create(
                baby,
                user,
                request.content(),
                request.dueDate(),
                request.priority(),
                request.category(),
                request.notes()
        );

        return checklistMapper.toDto(checklistRepository.save(checklist));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChecklistDto> getByBaby(Long babyId) {
        return checklistRepository.findByBabyId(babyId)
                .stream()
                .map(checklistMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChecklistDto> getByUser(Long userId) {
        return checklistRepository.findByUserId(userId)
                .stream()
                .map(checklistMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void markCompleted(Long checklistId) {
        findChecklist(checklistId).complete();
    }

    @Override
    @Transactional
    public void markIncomplete(Long checklistId) {
        findChecklist(checklistId).markIncomplete();
    }

    // Helper methods for entity retrieval
    private Baby findBaby(Long babyId) {
        return babyRepository.findById(babyId)
                .orElseThrow(() -> new ResourceNotFoundException("Baby", babyId,
                        "Baby with ID " + babyId + " not found"));
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId,
                        "User with ID " + userId + " not found"));
    }

    private Checklist findChecklist(Long checklistId) {
        return checklistRepository.findById(checklistId)
                .orElseThrow(() -> new ResourceNotFoundException("Checklist", checklistId,
                        "Checklist with ID " + checklistId + " not found"));
    }
}