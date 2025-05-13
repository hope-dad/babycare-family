package com.jack.babycarefamilybackend.application.usecase.record;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.infrastructure.mapper.record.FeedingRecordMapper;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.FeedingRecord;
import com.jack.babycarefamilybackend.domain.port.repository.FeedingRecordRepository;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.FeedingRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateFeedingRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedingRecordService {

    private final FeedingRecordMapper feedingRecordMapper;

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;
    private final FeedingRecordRepository feedingRecordRepository;

    @Transactional
    public FeedingRecordDto createFeedingRecord(CreateFeedingRecordRequest request) {

        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID", request.babyId() + "not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(), "user with Id", request.userId() + "not found"));

        FeedingRecord feedingRecord = feedingRecordMapper.toEntity(request, baby, user);
        FeedingRecord savedRecord = feedingRecordRepository.save(feedingRecord);
        return feedingRecordMapper.toDto(savedRecord);
    }

    @Transactional(readOnly = true)
    public List<FeedingRecordDto> getRecordsByBabyId(Long babyId) {
        return feedingRecordRepository.findByBabyId(babyId)
                .stream()
                .map(feedingRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<FeedingRecordDto> getRecordsByUserId(Long userId) {
        return feedingRecordRepository.findByUserId(userId)
                .stream()
                .map(feedingRecordMapper::toDto)
                .toList();
    }
}
