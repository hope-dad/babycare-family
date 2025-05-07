package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.record.mapper.IllnessRecordMapper;
import com.jack.babycarefamilybackend.domain.record.IllnessRecord;
import com.jack.babycarefamilybackend.domain.record.repository.IllnessRecordRepository;
import com.jack.babycarefamilybackend.dto.record.dto.IllnessRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateIllnessRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IllnessRecordService {

    private final IllnessRecordRepository illnessRecordRepository;
    private final IllnessRecordMapper illnessRecordMapper;

    @Transactional
    public IllnessRecordDto createIllnessRecord(CreateIllnessRecordRequest request) {
        IllnessRecord record = illnessRecordMapper.toEntity(request);
        IllnessRecord saved = illnessRecordRepository.save(record);
        return illnessRecordMapper.toDto(saved);
    }

    @Transactional(readOnly = true)
    public List<IllnessRecordDto> getByBabyId(Long babyId) {
        return illnessRecordRepository.findByBabyId(babyId)
                .stream()
                .map(illnessRecordMapper::toDto)
                .toList();
    }
}
