package com.jack.babycarefamilybackend.application.familygroup;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyGroupService {
    private final FamilyGroupRepository familyGroupRepository;

    public FamilyGroup create(String name) {
        return familyGroupRepository.save(new FamilyGroup(name));
    }

    public List<FamilyGroup> findAll() {
        return familyGroupRepository.findAll();
    }
}