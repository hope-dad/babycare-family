package com.jack.babycarefamilybackend.application.checklist;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.checklist.Checklist;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.checklist.ChecklistDto;
import com.jack.babycarefamilybackend.dto.checklist.CreateChecklistRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChecklistMapper {


    public Checklist toEntity(CreateChecklistRequest request, Baby baby, User user) {
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
