package com.jack.babycarefamilybackend.infrastructure.persistence.springdatajpa;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataBabyRepository extends JpaRepository<Baby, Long> {
    List<Baby> findByFamilyGroupId(Long familyGroupId);
}
