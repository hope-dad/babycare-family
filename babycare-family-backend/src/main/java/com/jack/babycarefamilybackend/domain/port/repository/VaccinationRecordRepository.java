package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.record.VaccinationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccinationRecordRepository extends JpaRepository<VaccinationRecord, Long> {
    List<VaccinationRecord> findByBabyId(Long babyId);
    List<VaccinationRecord> findByUserId(Long userId);
}
