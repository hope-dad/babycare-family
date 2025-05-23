package com.jack.babycarefamilybackend.infrastructure.mapper.checklist;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.checklist.Checklist;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.checklist.ChecklistDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-23T09:41:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class ChecklistMapperImpl implements ChecklistMapper {

    @Override
    public ChecklistDto toDto(Checklist checklist) {
        if ( checklist == null ) {
            return null;
        }

        Long babyId = null;
        Long userId = null;
        Long id = null;
        String content = null;
        boolean completed = false;
        LocalDateTime createdAt = null;
        LocalDateTime completedAt = null;
        LocalDate dueDate = null;
        Integer priority = null;
        String category = null;
        String notes = null;

        babyId = checklistBabyId( checklist );
        userId = checklistUserId( checklist );
        id = checklist.getId();
        content = checklist.getContent();
        completed = checklist.isCompleted();
        createdAt = checklist.getCreatedAt();
        completedAt = checklist.getCompletedAt();
        dueDate = checklist.getDueDate();
        priority = checklist.getPriority();
        category = checklist.getCategory();
        notes = checklist.getNotes();

        ChecklistDto checklistDto = new ChecklistDto( id, babyId, userId, content, completed, createdAt, completedAt, dueDate, priority, category, notes );

        return checklistDto;
    }

    private Long checklistBabyId(Checklist checklist) {
        if ( checklist == null ) {
            return null;
        }
        Baby baby = checklist.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long checklistUserId(Checklist checklist) {
        if ( checklist == null ) {
            return null;
        }
        User user = checklist.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
