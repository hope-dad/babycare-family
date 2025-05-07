package com.jack.babycarefamilybackend.application.checklist;

import com.jack.babycarefamilybackend.application.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.checklist.Checklist;
import com.jack.babycarefamilybackend.domain.checklist.ChecklistRepository;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.checklist.ChecklistDto;
import com.jack.babycarefamilybackend.dto.checklist.CreateChecklistRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChecklistService {

    private final ChecklistMapper checklistMapper;

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;
    private final ChecklistRepository checklistRepository;


    @Transactional
    public ChecklistDto create(CreateChecklistRequest request) {

        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(),
                        "Baby with ID", request.babyId() + "not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(),
                        "User with ID", request.userId() + "not found"));

        Checklist entity = checklistMapper.toEntity(request, baby, user);
        return checklistMapper.toDto(checklistRepository.save(entity));
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
                .orElseThrow(() -> new ResourceNotFoundException("Checklist",
                        checklistId, "checklist with ID", checklistId + "not found"));
        checklist.markCompleted();
    }

    @Transactional
    public void markIncomplete(Long checklistId) {
        Checklist checklist = checklistRepository.findById(checklistId)
                .orElseThrow(() -> new ResourceNotFoundException("Checklist",
                        checklistId, "checklist with ID", checklistId + "not found"));
        checklist.markIncomplete();
    }
}
