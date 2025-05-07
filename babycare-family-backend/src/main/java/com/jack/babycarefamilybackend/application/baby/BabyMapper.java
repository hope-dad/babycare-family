package com.jack.babycarefamilybackend.application.baby;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.dto.baby.BabyDto;
import com.jack.babycarefamilybackend.dto.baby.CreateBabyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BabyMapper {

    @Mapping(target = "familyGroup", source = "familyGroup")
    Baby toEntity(CreateBabyRequest request, FamilyGroup familyGroup);

    @Mapping(source = "familyGroup.id", target = "familyGroupId")
    BabyDto toDto(Baby baby);

}
