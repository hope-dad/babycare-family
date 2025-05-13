package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BabyRepository extends JpaRepository<Baby, Long> {

    List<Baby> findByFamilyGroupId(Long familyGroupId);

    boolean existsById(Long id);
}