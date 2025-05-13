package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.SleepRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.SleepRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateSleepRecordRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SleepRecordMapper {

    SleepRecord toEntity(CreateSleepRecordRequest request, Baby baby, User user);

    SleepRecordDto toDto(SleepRecord sleepRecord);
}
