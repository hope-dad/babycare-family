package com.jack.babycarefamilybackend.domain.record.repository;

import com.jack.babycarefamilybackend.domain.record.GrowthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrowthRecordRepository extends JpaRepository<GrowthRecord, Long> {
    List<GrowthRecord> findByBabyId(Long babyId);
    List<GrowthRecord> findByUserId(Long userId);
}
