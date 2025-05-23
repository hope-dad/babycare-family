package com.jack.babycarefamilybackend.infrastructure.mapper.baby;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.BabyDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.CreateBabyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BabyMapper {
    default Baby toEntity(CreateBabyRequest request, FamilyGroup familyGroup) {
        return new Baby(
                request.name(),
                request.birthDate(),
                request.gender(),
                familyGroup,
                request.photoUrl(),
                request.bloodType(),
                request.characteristics(),
                request.allergies(),
                request.prenatalName()
        );
    }

    @Mapping(target = "familyGroupId", source = "familyGroup.id")
    BabyDto toDto(Baby baby);
}

