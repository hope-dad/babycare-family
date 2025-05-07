package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.record.mapper.FeedingRecordMapper;
import com.jack.babycarefamilybackend.domain.record.FeedingRecord;
import com.jack.babycarefamilybackend.domain.record.repository.FeedingRecordRepository;
import com.jack.babycarefamilybackend.dto.record.request.CreateFeedingRecordRequest;
import com.jack.babycarefamilybackend.dto.record.dto.FeedingRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedingRecordService {

    private final FeedingRecordRepository feedingRecordRepository;
    private final FeedingRecordMapper feedingRecordMapper;

    @Transactional
    public FeedingRecordDto createFeedingRecord(CreateFeedingRecordRequest request) {
        FeedingRecord feedingRecord = feedingRecordMapper.toEntity(request);
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
