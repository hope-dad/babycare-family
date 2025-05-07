package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.MilestoneRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.record.dto.MilestoneRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateMilestoneRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface MilestoneRecordMapper {

    @Mapping(target = "baby", source = "baby")
    @Mapping(target = "user", source = "user")
    MilestoneRecord toEntity(CreateMilestoneRecordRequest request, Baby baby, User user);

    @Mapping(source = "baby.id", target = "babyId")
    @Mapping(source = "user.id", target = "userId")
    MilestoneRecordDto toDto(MilestoneRecord record);
}
