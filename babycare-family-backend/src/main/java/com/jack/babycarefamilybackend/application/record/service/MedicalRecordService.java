package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.dto.record.dto.MedicalRecordDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final MedicalRecordMapper medicalRecordMapper;

    @Transactional
    public MedicalRecordDto createMedicalRecord(CreateMedicalRecordRequest request) {
        MedicalRecord record = medicalRecordMapper.toEntity(request);
        MedicalRecord savedRecord = medicalRecordRepository.save(record);
        return medicalRecordMapper.toDto(savedRecord);
    }

    @Transactional(readOnly = true)
    public List<MedicalRecordDto> getRecordsByBabyId(Long babyId) {
        return medicalRecordRepository.findByBabyId(babyId)
                .stream()
                .map(medicalRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<MedicalRecordDto> getRecordsByUserId(Long userId) {
        return medicalRecordRepository.findByUserId(userId)
                .stream()
                .map(medicalRecordMapper::toDto)
                .toList();
    }
}