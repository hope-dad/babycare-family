package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.SleepRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.SleepRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateSleepRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SleepRecordMapper {


    default SleepRecord toEntity(CreateSleepRecordRequest request, Baby baby, User user) {
        return SleepRecord.create(
                baby,
                user,
                request.sleepStart(),
                request.sleepEnd(),
                request.note()
        );
    }
    @Mappings({
            @Mapping(target = "babyId", source = "baby.id"),
            @Mapping(target = "userId", source = "user.id"),
    })
    SleepRecordDto toDto(SleepRecord sleepRecord);
}
