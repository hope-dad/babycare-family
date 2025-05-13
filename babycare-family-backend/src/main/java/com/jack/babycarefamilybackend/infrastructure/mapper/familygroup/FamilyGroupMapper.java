package com.jack.babycarefamilybackend.infrastructure.mapper.familygroup;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.infrastructure.web.dto.familygroup.CreateFamilyGroupRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.familygroup.FamilyGroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FamilyGroupMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true)
    })
    FamilyGroup toEntity(CreateFamilyGroupRequest request);


    @Mappings({
            @Mapping(target = "id", source = "familyGroup.id"),
            @Mapping(target = "name", source = "familyGroup.name"),
            @Mapping(target = "createdAt", source = "familyGroup.createdAt")
    })
    FamilyGroupDto toDto(FamilyGroup familyGroup);
}