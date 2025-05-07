package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.record.mapper.MilestoneRecordMapper;
import com.jack.babycarefamilybackend.domain.record.MilestoneRecord;
import com.jack.babycarefamilybackend.domain.record.repository.MilestoneRecordRepository;
import com.jack.babycarefamilybackend.dto.record.dto.MilestoneRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateMilestoneRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneRecordService {

    private final MilestoneRecordRepository milestoneRecordRepository;
    private final MilestoneRecordMapper milestoneRecordMapper;

    @Transactional
    public MilestoneRecordDto createMilestone(CreateMilestoneRecordRequest request) {
        MilestoneRecord record = milestoneRecordMapper.toEntity(request);
        return milestoneRecordMapper.toDto(milestoneRecordRepository.save(record));
    }

    @Transactional(readOnly = true)
    public List<MilestoneRecordDto> getByBabyId(Long babyId) {
        return milestoneRecordRepository.findByBabyId(babyId)
                .stream()
                .map(milestoneRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<MilestoneRecordDto> getByUserId(Long userId) {
        return milestoneRecordRepository.findByUserId(userId)
                .stream()
                .map(milestoneRecordMapper::toDto)
                .toList();
    }
}
