package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.record.mapper.DiaperRecordMapper;
import com.jack.babycarefamilybackend.domain.record.DiaperRecord;
import com.jack.babycarefamilybackend.domain.record.repository.DiaperRecordRepository;
import com.jack.babycarefamilybackend.dto.record.dto.DiaperRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateDiaperRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaperRecordService {

    private final DiaperRecordRepository diaperRecordRepository;
    private final DiaperRecordMapper diaperRecordMapper;

    @Transactional
    public DiaperRecordDto createDiaperRecord(CreateDiaperRecordRequest request) {
        DiaperRecord diaperRecord = diaperRecordMapper.toEntity(request);
        DiaperRecord savedRecord = diaperRecordRepository.save(diaperRecord);
        return diaperRecordMapper.toDto(savedRecord);
    }

    @Transactional(readOnly = true)
    public List<DiaperRecordDto> getRecordsByBabyId(Long babyId) {
        return diaperRecordRepository.findByBabyId(babyId)
                .stream()
                .map(diaperRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<DiaperRecordDto> getRecordsByUserId(Long userId) {
        return diaperRecordRepository.findByUserId(userId)
                .stream()
                .map(diaperRecordMapper::toDto)
                .toList();
    }
}
