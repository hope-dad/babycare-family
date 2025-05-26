package com.jack.babycarefamilybackend.application.usecase.baby;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.Gender;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.port.repository.FamilyGroupRepository;
import com.jack.babycarefamilybackend.infrastructure.mapper.baby.BabyMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.BabyDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.CreateBabyRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.UpdateBabyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BabyServiceImpl implements BabyService {

    private final BabyRepository babyRepository;
    private final FamilyGroupRepository familyGroupRepository;
    private final BabyMapper babyMapper;

    @Override
    @Transactional
    public BabyDto createBaby(CreateBabyRequest request) {
        FamilyGroup familyGroup = familyGroupRepository.findById(request.familyGroupId())
                .orElseThrow(() -> new ResourceNotFoundException("FamilyGroup", request.familyGroupId(), "Family Group not found"));

        Baby baby = babyMapper.toEntity(request, familyGroup);
        Baby savedBaby = babyRepository.save(baby);
        return babyMapper.toDto(savedBaby);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BabyDto> getBabiesByFamilyGroup(Long familyGroupId) {
        return babyRepository.findByFamilyGroupId(familyGroupId)
                .stream()
                .map(babyMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BabyDto getBabyById(Long babyId) {
        Baby baby = babyRepository.findById(babyId)
                .orElseThrow(() -> new ResourceNotFoundException("Baby", babyId, "Baby not found"));
        return babyMapper.toDto(baby);
    }

    @Override
    @Transactional
    public BabyDto updateBaby(Long babyId, UpdateBabyRequest request) {
        Baby existingBaby = babyRepository.findById(babyId)
                .orElseThrow(() -> new ResourceNotFoundException("Baby", babyId, "Baby not found"));

        FamilyGroup familyGroup = familyGroupRepository.findById(request.familyGroupId())
                .orElseThrow(() -> new ResourceNotFoundException("FamilyGroup", request.familyGroupId(), "Family Group not found"));

        // Gender 문자열 → Enum 안전 변환
        Gender gender = Gender.from(request.gender());

        // 엔티티 메서드를 통해 업데이트 진행 (Setter보다 명확한 메서드 권장)
        existingBaby.updateBabyInfo(
                request.name(),
                request.birthDate(),
                gender,
                familyGroup,
                request.photoUrl(),
                request.bloodType(),
                request.characteristics(),
                request.allergies(),
                request.prenatalName()
        );

        Baby updatedBaby = babyRepository.save(existingBaby);
        return babyMapper.toDto(updatedBaby);
    }

    @Override
    @Transactional
    public void deleteBaby(Long babyId) {
        Baby baby = babyRepository.findById(babyId)
                .orElseThrow(() -> new ResourceNotFoundException("Baby", babyId, "Baby not found"));

        baby.softDelete();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long babyId) {
        return babyRepository.existsById(babyId);
    }



}
