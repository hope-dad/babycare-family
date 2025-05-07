package com.jack.babycarefamilybackend.domain.record.repository;

import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BabyRecordRepository extends JpaRepository<BabyRecord, Long> {
}
