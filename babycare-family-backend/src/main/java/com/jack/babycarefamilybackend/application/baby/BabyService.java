package com.jack.babycarefamilybackend.application.baby;

import com.jack.babycarefamilybackend.application.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroupRepository;
import com.jack.babycarefamilybackend.dto.baby.BabyDto;
import com.jack.babycarefamilybackend.dto.baby.CreateBabyRequest;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BabyService {

    private final BabyMapper babyMapper;
    private final BabyRepository babyRepository;
    private final FamilyGroupRepository familyGroupRepository;

    @Transactional
    public BabyDto createBaby(CreateBabyRequest request) {

        FamilyGroup familyGroup = familyGroupRepository.findById(request.familyGroupId())
                .orElseThrow(() -> new ResourceNotFoundException("FamilyGroup", request.familyGroupId(), "Family Group With ID" + request.familyGroupId() + "not found"));
        Baby baby = babyMapper.toEntity(request, familyGroup);
        Baby savedBaby = babyRepository.save(baby);
        return babyMapper.toDto(savedBaby);
    }

    @Transactional(readOnly = true)
    public List<BabyDto> getBabiesByFamilyGroup(Long familyGroupId) {
        return babyRepository.findByFamilyGroupId(familyGroupId)
                .stream()
                .map(babyMapper::toDto)
                .toList();
    }
}
