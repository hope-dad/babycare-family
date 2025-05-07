package com.jack.babycarefamilybackend.domain.record.repository;

public interface VaccinationRecordRepository extends JpaRepository<VaccinationRecord, Long> {
    List<VaccinationRecord> findByBabyId(Long babyId);
    List<VaccinationRecord> findByUserId(Long userId);
}
