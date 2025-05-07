package com.jack.babycarefamilybackend.application.checklist;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.checklist.Checklist;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.checklist.ChecklistDto;
import com.jack.babycarefamilybackend.dto.checklist.CreateChecklistRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChecklistMapper {

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    public Checklist toEntity(CreateChecklistRequest request) {
        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new IllegalArgumentException("Baby not found"));
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return new Checklist(baby, user, request.content());
    }

    public ChecklistDto toDto(Checklist checklist) {
        return new ChecklistDto(
                checklist.getId(),
                checklist.getBaby().getId(),
                checklist.getUser().getId(),
                checklist.getContent(),
                checklist.isCompleted(),
                checklist.getCreatedAt(),
                checklist.getCompletedAt()
        );
    }
}
