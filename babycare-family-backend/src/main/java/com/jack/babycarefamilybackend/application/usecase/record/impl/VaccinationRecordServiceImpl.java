package com.jack.babycarefamilybackend.application.usecase.record.impl;

import com.jack.babycarefamilybackend.application.usecase.record.service.VaccinationRecordService;
import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.domain.port.repository.VaccinationRecordRepository;
import com.jack.babycarefamilybackend.domain.record.VaccinationRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.mapper.record.VaccinationRecordMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.VaccinationRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateVaccinationRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccinationRecordServiceImpl implements VaccinationRecordService {

    private final VaccinationRecordMapper vaccinationRecordMapper;

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;
    private final VaccinationRecordRepository vaccinationRecordRepository;

    @Override
    @Transactional
    public VaccinationRecordDto createVaccinationRecord(CreateVaccinationRecordRequest request) {

        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID", request.babyId() + "not found"));
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(), "user with Id", request.userId() + "not found"));

        VaccinationRecord record = vaccinationRecordMapper.toEntity(request, baby, user);
        VaccinationRecord savedRecord = vaccinationRecordRepository.save(record);
        return vaccinationRecordMapper.toDto(savedRecord);
    }
    @Override
    @Transactional(readOnly = true)
    public List<VaccinationRecordDto> getRecordsByBabyId(Long babyId) {
        return vaccinationRecordRepository.findByBabyId(babyId)
                .stream()
                .map(vaccinationRecordMapper::toDto)
                .toList();
    }
    @Override
    @Transactional(readOnly = true)
    public List<VaccinationRecordDto> getRecordsByUserId(Long userId) {
        return vaccinationRecordRepository.findByUserId(userId)
                .stream()
                .map(vaccinationRecordMapper::toDto)
                .toList();
    }
}
