package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.record.FeedingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedingRecordRepository extends JpaRepository<FeedingRecord, Long> {
    List<FeedingRecord> findByBabyId(Long babyId);
    List<FeedingRecord> findByUserId(Long userId);
}