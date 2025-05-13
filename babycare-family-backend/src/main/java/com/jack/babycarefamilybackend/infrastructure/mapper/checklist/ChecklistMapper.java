package com.jack.babycarefamilybackend.infrastructure.mapper.checklist;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.checklist.Checklist;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.checklist.ChecklistDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.checklist.CreateChecklistRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ChecklistMapper {

    default Checklist toEntity(CreateChecklistRequest request, Baby baby, User user) {
        return Checklist.create(
                baby,
                user,
                request.content(),
                request.dueDate(),
                request.priority(),
                request.category(),
                request.notes()
        );
    }

    @Mappings({
            @Mapping(target = "babyId", source = "checklist.baby.id"),
            @Mapping(target = "userId", source = "checklist.user.id")
    })
    ChecklistDto toDto(Checklist checklist);
}

