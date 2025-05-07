package com.jack.babycarefamilybackend.application.familygroup;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.dto.familygroup.CreateFamilyGroupRequest;
import com.jack.babycarefamilybackend.dto.familygroup.FamilyGroupDto;
import org.springframework.stereotype.Component;

@Component
public class FamilyGroupMapper {

    public FamilyGroup toEntity(CreateFamilyGroupRequest request) {
        return new FamilyGroup(request.name());
    }

    public FamilyGroupDto toDto(FamilyGroup familyGroup) {
        return new FamilyGroupDto(
                familyGroup.getId(),
                familyGroup.getName(),
                familyGroup.getCreatedAt()
        );
    }
}
