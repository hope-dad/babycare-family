package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.record.HospitalVisitRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalVisitRecordRepository extends JpaRepository<HospitalVisitRecord, Long> {
    List<HospitalVisitRecord> findByBabyId(Long babyId);
    List<HospitalVisitRecord> findByUserId(Long userId);
}
