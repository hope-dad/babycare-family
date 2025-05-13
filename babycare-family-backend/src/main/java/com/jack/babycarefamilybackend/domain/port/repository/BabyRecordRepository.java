package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BabyRecordRepository extends JpaRepository<BabyRecord, Long> {
}
