package com.jack.babycarefamilybackend.domain.baby;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BabyRepository extends JpaRepository<Baby, Long> {
    List<Baby> findByFamilyGroupId(Long familyGroupId);
}