package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.SleepRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.record.dto.SleepRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateSleepRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SleepRecordMapper {

    @Mapping(target = "baby", source = "baby")
    @Mapping(target = "user", source = "user")
    SleepRecord toEntity(CreateSleepRecordRequest request, Baby baby, User user);

    @Mapping(source = "baby.id", target = "babyId")
    @Mapping(source = "user.id", target = "userId")
    SleepRecordDto toDto(SleepRecord sleepRecord);
}
