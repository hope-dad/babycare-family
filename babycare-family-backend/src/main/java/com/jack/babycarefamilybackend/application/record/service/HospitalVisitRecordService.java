package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.application.record.mapper.HospitalVisitRecordMapper;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.HospitalVisitRecord;
import com.jack.babycarefamilybackend.domain.record.repository.HospitalVisitRecordRepository;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.dto.HospitalVisitRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateHospitalVisitRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalVisitRecordService {

    private final HospitalVisitRecordMapper hospitalVisitRecordMapper;

    private final HospitalVisitRecordRepository hospitalVisitRecordRepository;
    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    @Transactional
    public HospitalVisitRecordDto createRecord(CreateHospitalVisitRecordRequest request) {
        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID",request.babyId() + "not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(), "user with Id", request.userId() + "not found"));

        HospitalVisitRecord record = hospitalVisitRecordMapper.toEntity(request, baby, user);
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