package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.record.mapper.VaccinationRecordMapper;
import com.jack.babycarefamilybackend.domain.record.VaccinationRecord;
import com.jack.babycarefamilybackend.domain.record.repository.VaccinationRecordRepository;
import com.jack.babycarefamilybackend.dto.record.dto.VaccinationRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateVaccinationRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccinationRecordService {

    private final VaccinationRecordRepository vaccinationRecordRepository;
    private final VaccinationRecordMapper vaccinationRecordMapper;

    @Transactional
    public VaccinationRecordDto createVaccinationRecord(CreateVaccinationRecordRequest request) {
        VaccinationRecord record = vaccinationRecordMapper.toEntity(request);
        VaccinationRecord savedRecord = vaccinationRecordRepository.save(record);
        return vaccinationRecordMapper.toDto(savedRecord);
    }

    @Transactional(readOnly = true)
    public List<VaccinationRecordDto> getRecordsByBabyId(Long babyId) {
        return vaccinationRecordRepository.findByBabyId(babyId)
                .stream()
                .map(vaccinationRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<VaccinationRecordDto> getRecordsByUserId(Long userId) {
        return vaccinationRecordRepository.findByUserId(userId)
                .stream()
                .map(vaccinationRecordMapper::toDto)
                .toList();
    }
}
