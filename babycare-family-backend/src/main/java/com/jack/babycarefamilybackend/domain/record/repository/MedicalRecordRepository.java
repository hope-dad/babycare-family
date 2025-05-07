package com.jack.babycarefamilybackend.domain.record.repository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByBabyId(Long babyId);
    List<MedicalRecord> findByUserId(Long userId);
}