package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.record.SleepRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SleepRecordRepository extends JpaRepository<SleepRecord, Long> {
    List<SleepRecord> findByBabyId(Long babyId);
    List<SleepRecord> findByUserId(Long userId);
}
