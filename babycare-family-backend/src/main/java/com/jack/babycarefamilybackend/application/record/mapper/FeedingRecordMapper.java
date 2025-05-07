package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.FeedingRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.record.dto.FeedingRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateFeedingRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface FeedingRecordMapper {


    @Mapping(target = "baby", source = "baby")
    @Mapping(target = "user", source = "user")
    FeedingRecord toEntity(CreateFeedingRecordRequest request, Baby baby, User user);

    @Mapping(source = "baby.id", target = "babyId")
    @Mapping(source = "user.id", target = "userId")
    FeedingRecordDto toDto(FeedingRecord feedingRecord);

}

