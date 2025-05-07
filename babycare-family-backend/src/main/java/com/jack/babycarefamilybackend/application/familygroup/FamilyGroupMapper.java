package com.jack.babycarefamilybackend.application.familygroup;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.dto.familygroup.CreateFamilyGroupRequest;
import com.jack.babycarefamilybackend.dto.familygroup.FamilyGroupDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FamilyGroupMapper {

    FamilyGroup toEntity(CreateFamilyGroupRequest request);

    FamilyGroupDto toDto(FamilyGroup familyGroup);

}
