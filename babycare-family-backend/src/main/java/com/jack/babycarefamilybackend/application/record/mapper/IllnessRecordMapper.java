package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.IllnessRecord;
import com.jack.babycarefamilybackend.dto.record.dto.IllnessRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateIllnessRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IllnessRecordMapper {

    private final BabyRepository babyRepository;

    public IllnessRecord toEntity(CreateIllnessRecordRequest request, Baby baby) {

        return new IllnessRecord(
                baby,
                request.symptom(),
                request.startDate(),
                request.endDate(),
                request.note()
        );
    }

    public IllnessRecordDto toDto(IllnessRecord record) {
        return new IllnessRecordDto(
                record.getId(),
                record.getBaby().getId(),
                record.getSymptom(),
                record.getStartDate(),
                record.getEndDate(),
                record.getNote()
        );
    }
}