package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.FeedingRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.FeedingRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateFeedingRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FeedingRecordMapper {


    @Mapping(target = "id", ignore = true)
    FeedingRecord toEntity(CreateFeedingRecordRequest request, Baby baby, User user);

    FeedingRecordDto toDto(FeedingRecord feedingRecord);

}

