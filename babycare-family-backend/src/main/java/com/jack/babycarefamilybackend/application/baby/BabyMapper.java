package com.jack.babycarefamilybackend.application.baby;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroupRepository;
import com.jack.babycarefamilybackend.dto.baby.BabyDto;
import com.jack.babycarefamilybackend.dto.baby.CreateBabyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BabyMapper {

    private final FamilyGroupRepository familyGroupRepository;

    public Baby toEntity(CreateBabyRequest request) {
        FamilyGroup familyGroup = familyGroupRepository.findById(request.familyGroupId())
                .orElseThrow(() -> new IllegalArgumentException("Family Group not found"));

        return new Baby(request.name(), request.birthDate(), request.gender(), familyGroup);
    }

    public BabyDto toDto(Baby baby) {
        return new BabyDto(
                baby.getId(),
                baby.getName(),
                baby.getBirthDate(),
                baby.getGender(),
                baby.getFamilyGroup().getId()
        );
    }
}
