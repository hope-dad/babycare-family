package com.jack.babycarefamilybackend.domain.record.repository;

public interface GrowthRecordRepository extends JpaRepository<GrowthRecord, Long> {
    List<GrowthRecord> findByBabyId(Long babyId);
    List<GrowthRecord> findByUserId(Long userId);
}
