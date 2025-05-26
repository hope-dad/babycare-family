package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.port.repository.MedicalRecordRepository;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.domain.record.MedicalRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.mapper.record.MedicalRecordMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.MedicalRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateMedicalRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordMapper medicalRecordMapper;

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    @Transactional
    public MedicalRecordDto createMedicalRecord(CreateMedicalRecordRequest request) {
        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID",request.babyId() + "not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(), "user with Id", request.userId() + "not found"));

        MedicalRecord record = medicalRecordMapper.toEntity(request, baby, user);
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