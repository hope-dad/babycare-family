package com.jack.babycarefamilybackend.application.usecase.record;


import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.port.repository.SleepRecordRepository;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.domain.record.SleepRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.mapper.record.SleepRecordMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.SleepRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateSleepRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SleepRecordService {

    private final SleepRecordMapper sleepRecordMapper;
    private final BabyRepository babyRepository;
    private final UserRepository userRepository;
    private final SleepRecordRepository sleepRecordRepository;


    @Transactional
    public SleepRecordDto createSleepRecord(CreateSleepRecordRequest request) {

        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID",request.babyId() + "not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(), "user with Id", request.userId() + "not found"));

        SleepRecord sleepRecord = sleepRecordMapper.toEntity(request, baby, user);
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