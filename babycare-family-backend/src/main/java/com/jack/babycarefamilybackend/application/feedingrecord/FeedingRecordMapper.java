package com.jack.babycarefamilybackend.application.feedingrecord;

import com.jack.babycarefamilybackend.domain.record.feddingrecord.FeedingRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.feedingrecord.CreateFeedingRecordRequest;
import com.jack.babycarefamilybackend.dto.feedingrecord.FeedingRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedingRecordMapper {
    private final UserRepository userRepository;

    public FeedingRecord toEntity(CreateFeedingRecordRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new FeedingRecord(request.type(), request.amount(), request.fedAt(), user);
    }

    public FeedingRecordDto toDto(FeedingRecord record) {
        return new FeedingRecordDto(
                record.getId(),
                record.getType(),
                record.getAmount(),
                record.getFedAt(),
                record.getUser().getId()
        );
    }
}

