package com.jack.babycarefamilybackend.application.baby;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.dto.baby.BabyDto;
import com.jack.babycarefamilybackend.dto.baby.CreateBabyRequest;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BabyService {

    private final BabyRepository babyRepository;
    private final BabyMapper babyMapper;

    @Transactional
    public BabyDto createBaby(CreateBabyRequest request) {
        Baby baby = babyMapper.toEntity(request);
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
