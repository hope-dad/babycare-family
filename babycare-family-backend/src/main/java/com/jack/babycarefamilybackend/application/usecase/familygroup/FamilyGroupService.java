package com.jack.babycarefamilybackend.application.usecase.familygroup;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.port.repository.FamilyGroupRepository;
import com.jack.babycarefamilybackend.infrastructure.mapper.familygroup.FamilyGroupMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.familygroup.CreateFamilyGroupRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.familygroup.FamilyGroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 원본 클래스의 Transactional 설정을 그대로 옮겼습니다.
public class FamilyGroupService {

    private final FamilyGroupRepository familyGroupRepository;
    private final FamilyGroupMapper familyGroupMapper;


    @Transactional // 쓰기 작업에는 별도 Transactional 어노테이션 적용
    public FamilyGroupDto createFamilyGroup(CreateFamilyGroupRequest request) {
        FamilyGroup familyGroup = familyGroupMapper.toEntity(request);
        FamilyGroup savedGroup = familyGroupRepository.save(familyGroup);
        return familyGroupMapper.toDto(savedGroup);
    }


    public List<FamilyGroupDto> getAllFamilyGroups() {
        return familyGroupRepository.findAll()
                .stream()
                .map(familyGroupMapper::toDto)
                .toList();
    }


    public FamilyGroupDto getFamilyGroupById(Long groupId) {
        FamilyGroup familyGroup = familyGroupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("FamilyGroup", groupId,
                        // ✨ 여기 메시지에 띄어쓰기 수정 제안!
                        "FamilyGroup with ID " + groupId + " not found"));
        return familyGroupMapper.toDto(familyGroup);
    }
}
