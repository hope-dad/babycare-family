package com.jack.babycarefamilybackend.domain.port.repository;


import com.jack.babycarefamilybackend.domain.record.IllnessRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IllnessRecordRepository extends JpaRepository<IllnessRecord, Long> {
    List<IllnessRecord> findByBabyId(Long babyId);
}
