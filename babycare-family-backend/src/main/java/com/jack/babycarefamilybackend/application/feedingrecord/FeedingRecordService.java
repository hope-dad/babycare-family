package com.jack.babycarefamilybackend.application.feedingrecord;

import com.jack.babycarefamilybackend.domain.record.feddingrecord.FeedingRecord;
import com.jack.babycarefamilybackend.domain.record.feddingrecord.FeedingRecordRepository;
import com.jack.babycarefamilybackend.dto.feedingrecord.CreateFeedingRecordRequest;
import com.jack.babycarefamilybackend.dto.feedingrecord.FeedingRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedingRecordService {
    private final FeedingRecordRepository feedingRecordRepository;
    private final FeedingRecordMapper feedingRecordMapper;

    public FeedingRecordDto create(CreateFeedingRecordRequest request) {
        FeedingRecord saved = feedingRecordRepository.save(
                feedingRecordMapper.toEntity(request)
        );
        return feedingRecordMapper.toDto(saved);
    }

    public List<FeedingRecordDto> findAllByUser(Long userId) {
        return feedingRecordRepository.findByUserId(userId)
                .stream()
                .map(feedingRecordMapper::toDto)
                .toList();
    }
}
