package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.record.mapper.HospitalVisitRecordMapper;
import com.jack.babycarefamilybackend.domain.record.HospitalVisitRecord;
import com.jack.babycarefamilybackend.domain.record.repository.HospitalVisitRecordRepository;
import com.jack.babycarefamilybackend.dto.record.dto.HospitalVisitRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateHospitalVisitRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalVisitRecordService {

    private final HospitalVisitRecordRepository hospitalVisitRecordRepository;
    private final HospitalVisitRecordMapper hospitalVisitRecordMapper;

    @Transactional
    public HospitalVisitRecordDto createRecord(CreateHospitalVisitRecordRequest request) {
        HospitalVisitRecord record = hospitalVisitRecordMapper.toEntity(request);
        return hospitalVisitRecordMapper.toDto(hospitalVisitRecordRepository.save(record));
    }

    @Transactional(readOnly = true)
    public List<HospitalVisitRecordDto> getByBabyId(Long babyId) {
        return hospitalVisitRecordRepository.findByBabyId(babyId)
                .stream()
                .map(hospitalVisitRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<HospitalVisitRecordDto> getByUserId(Long userId) {
        return hospitalVisitRecordRepository.findByUserId(userId)
                .stream()
                .map(hospitalVisitRecordMapper::toDto)
                .toList();
    }
}