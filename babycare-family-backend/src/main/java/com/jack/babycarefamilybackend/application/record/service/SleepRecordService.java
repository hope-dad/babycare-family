package com.jack.babycarefamilybackend.application.record.service;


import com.jack.babycarefamilybackend.application.record.mapper.SleepRecordMapper;
import com.jack.babycarefamilybackend.domain.record.SleepRecord;
import com.jack.babycarefamilybackend.domain.record.repository.SleepRecordRepository;
import com.jack.babycarefamilybackend.dto.record.dto.SleepRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateSleepRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SleepRecordService {

    private final SleepRecordRepository sleepRecordRepository;
    private final SleepRecordMapper sleepRecordMapper;

    @Transactional
    public SleepRecordDto createSleepRecord(CreateSleepRecordRequest request) {
        SleepRecord sleepRecord = sleepRecordMapper.toEntity(request);
        SleepRecord savedRecord = sleepRecordRepository.save(sleepRecord);
        return sleepRecordMapper.toDto(savedRecord);
    }

    @Transactional(readOnly = true)
    public List<SleepRecordDto> getRecordsByBabyId(Long babyId) {
        return sleepRecordRepository.findByBabyId(babyId)
                .stream()
                .map(sleepRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<SleepRecordDto> getRecordsByUserId(Long userId) {
        return sleepRecordRepository.findByUserId(userId)
                .stream()
                .map(sleepRecordMapper::toDto)
                .toList();
    }
}