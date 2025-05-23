package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.FeedingRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.FeedingRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateFeedingRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FeedingRecordMapper {

    default FeedingRecord toEntity(CreateFeedingRecordRequest request, Baby baby, User user) {
        return FeedingRecord.create(
                baby,
                user,
                request.type(),
                request.amount(),
                request.fedAt()
        );
    }

    @Mappings({
            @Mapping(target = "babyId", source = "baby.id"),
            @Mapping(target = "userId", source = "user.id")
    })
    FeedingRecordDto toDto(FeedingRecord feedingRecord);

}

