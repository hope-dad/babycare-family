package com.jack.babycarefamilybackend.domain.record.repository;

import com.jack.babycarefamilybackend.domain.record.DiaperRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaperRecordRepository extends JpaRepository<DiaperRecord, Long> {
    List<DiaperRecord> findByBabyId(Long babyId);
    List<DiaperRecord> findByUserId(Long userId);
}
