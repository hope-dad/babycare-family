package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.application.record.mapper.GrowthRecordMapper;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.GrowthRecord;
import com.jack.babycarefamilybackend.domain.record.repository.GrowthRecordRepository;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.dto.GrowthRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateGrowthRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrowthRecordService {

    private final GrowthRecordMapper growthRecordMapper;

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;
    private final GrowthRecordRepository growthRecordRepository;

    @Transactional
    public GrowthRecordDto createGrowthRecord(CreateGrowthRecordRequest request) {

        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID", request.babyId() + "not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(), "user with Id", request.userId() + "not found"));

        GrowthRecord growthRecord = growthRecordMapper.toEntity(request, baby, user);
        GrowthRecord savedRecord = growthRecordRepository.save(growthRecord);
        return growthRecordMapper.toDto(savedRecord);
    }

    @Transactional(readOnly = true)
    public List<GrowthRecordDto> getRecordsByBabyId(Long babyId) {
        return growthRecordRepository.findByBabyId(babyId)
                .stream()
                .map(growthRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GrowthRecordDto> getRecordsByUserId(Long userId) {
        return growthRecordRepository.findByUserId(userId)
                .stream()
                .map(growthRecordMapper::toDto)
                .toList();
    }
}
