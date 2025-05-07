package com.jack.babycarefamilybackend.application.familygroup;

import com.jack.babycarefamilybackend.application.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroupRepository;
import com.jack.babycarefamilybackend.dto.familygroup.CreateFamilyGroupRequest;
import com.jack.babycarefamilybackend.dto.familygroup.FamilyGroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyGroupService {

    private final FamilyGroupRepository familyGroupRepository;
    private final FamilyGroupMapper familyGroupMapper;

    @Transactional
    public FamilyGroupDto createFamilyGroup(CreateFamilyGroupRequest request) {
        FamilyGroup familyGroup = familyGroupMapper.toEntity(request);
        FamilyGroup savedGroup = familyGroupRepository.save(familyGroup);
        return familyGroupMapper.toDto(savedGroup);
    }

    @Transactional(readOnly = true)
    public List<FamilyGroupDto> getAllFamilyGroups() {
        return familyGroupRepository.findAll()
                .stream()
                .map(familyGroupMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public FamilyGroupDto getFamilyGroupById(Long groupId) {
        FamilyGroup familyGroup = familyGroupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("FamilyGroup", groupId,
                        "FamilyGroup with ID"+ groupId + " not found"));
        return familyGroupMapper.toDto(familyGroup);
    }
}