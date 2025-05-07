package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.FeedingRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.request.CreateFeedingRecordRequest;
import com.jack.babycarefamilybackend.dto.record.dto.FeedingRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedingRecordMapper {


    public FeedingRecord toEntity(CreateFeedingRecordRequest request, Baby baby, User user) {

        return new FeedingRecord(
                baby,
                user,
                request.type(),
                request.amount(),
                request.fedAt()
        );
    }

    public FeedingRecordDto toDto(FeedingRecord feedingRecord) {
        return new FeedingRecordDto(
                feedingRecord.getId(),
                feedingRecord.getBaby().getId(),
                feedingRecord.getUser().getId(),
                feedingRecord.getType(),
                feedingRecord.getAmount(),
                feedingRecord.getFedAt()
        );
    }
}

