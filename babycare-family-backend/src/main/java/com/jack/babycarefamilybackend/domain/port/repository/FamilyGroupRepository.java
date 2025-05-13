package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyGroupRepository extends JpaRepository<FamilyGroup, Long> {}
