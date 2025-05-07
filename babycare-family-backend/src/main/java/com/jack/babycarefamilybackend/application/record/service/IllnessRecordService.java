package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.application.record.mapper.IllnessRecordMapper;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
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

    private final IllnessRecordMapper illnessRecordMapper;

    private final IllnessRecordRepository illnessRecordRepository;
    private final BabyRepository babyRepository;


    @Transactional
    public IllnessRecordDto createIllnessRecord(CreateIllnessRecordRequest request) {
        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID",request.babyId() + "not found"));

        IllnessRecord record = illnessRecordMapper.toEntity(request, baby);
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
