package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.port.repository.MilestoneRecordRepository;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.domain.record.MilestoneRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.mapper.record.MilestoneRecordMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.MilestoneRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateMilestoneRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneRecordService {

    private final MilestoneRecordMapper milestoneRecordMapper;
    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    private final MilestoneRecordRepository milestoneRecordRepository;

    @Transactional
    public MilestoneRecordDto createMilestone(CreateMilestoneRecordRequest request) {

        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID",request.babyId() + "not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(), "user with Id", request.userId() + "not found"));

        MilestoneRecord record = milestoneRecordMapper.toEntity(request, baby, user);
        return milestoneRecordMapper.toDto(milestoneRecordRepository.save(record));
    }

    @Transactional(readOnly = true)
    public List<MilestoneRecordDto> getByBabyId(Long babyId) {
        return milestoneRecordRepository.findByBabyId(babyId)
                .stream()
                .map(milestoneRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<MilestoneRecordDto> getByUserId(Long userId) {
        return milestoneRecordRepository.findByUserId(userId)
                .stream()
                .map(milestoneRecordMapper::toDto)
                .toList();
    }
}
