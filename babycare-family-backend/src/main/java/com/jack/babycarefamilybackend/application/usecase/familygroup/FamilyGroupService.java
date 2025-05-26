package com.jack.babycarefamilybackend.application.usecase.familygroup;

import com.jack.babycarefamilybackend.infrastructure.web.dto.familygroup.CreateFamilyGroupRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.familygroup.FamilyGroupDto;

import java.util.List;

public interface FamilyGroupService {
    FamilyGroupDto createFamilyGroup(CreateFamilyGroupRequest request);
    List<FamilyGroupDto> getAllFamilyGroups();
    FamilyGroupDto getFamilyGroupById(Long groupId);
}
