package com.jack.babycarefamilybackend.domain.record.feddingrecord;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedingRecordRepository extends JpaRepository<FeedingRecord, Long> {
    List<FeedingRecord> findByUserId(Long userId);
}
