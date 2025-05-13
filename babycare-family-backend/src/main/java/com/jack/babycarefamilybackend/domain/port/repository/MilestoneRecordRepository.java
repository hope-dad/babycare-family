package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.record.MilestoneRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MilestoneRecordRepository extends JpaRepository<MilestoneRecord, Long> {
    List<MilestoneRecord> findByBabyId(Long babyId);
    List<MilestoneRecord> findByUserId(Long userId);
}
