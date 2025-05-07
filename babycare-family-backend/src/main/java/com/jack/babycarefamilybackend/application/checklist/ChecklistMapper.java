package com.jack.babycarefamilybackend.application.checklist;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.checklist.Checklist;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.checklist.ChecklistDto;
import com.jack.babycarefamilybackend.dto.checklist.CreateChecklistRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // Spring Bean으로 자동 등록!
public interface ChecklistMapper {

    @Mapping(target = "baby", source = "baby")
    @Mapping(target = "user", source = "user")
    Checklist toEntity(CreateChecklistRequest request, Baby baby, User user);

    @Mapping(source = "baby.id", target = "babyId")
    @Mapping(source = "user.id", target = "userId")
    ChecklistDto toDto(Checklist checklist);

}
