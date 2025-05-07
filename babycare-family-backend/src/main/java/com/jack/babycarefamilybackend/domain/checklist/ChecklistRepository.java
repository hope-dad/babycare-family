package com.jack.babycarefamilybackend.domain.checklist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    List<Checklist> findByBabyId(Long babyId);
    List<Checklist> findByUserId(Long userId);
}
