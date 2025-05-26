package com.jack.babycarefamilybackend.application.usecase.record;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.port.repository.IllnessRecordRepository;
import com.jack.babycarefamilybackend.domain.record.IllnessRecord;
import com.jack.babycarefamilybackend.infrastructure.mapper.record.IllnessRecordMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.IllnessRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateIllnessRecordRequest;
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
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID", request.babyId() + "not found"));

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
