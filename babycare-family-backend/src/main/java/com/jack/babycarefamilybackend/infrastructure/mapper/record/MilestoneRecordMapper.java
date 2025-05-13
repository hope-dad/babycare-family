package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.MilestoneRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.MilestoneRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateMilestoneRecordRequest;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MilestoneRecordMapper {

    MilestoneRecord toEntity(CreateMilestoneRecordRequest request, Baby baby, User user);

    MilestoneRecordDto toDto(MilestoneRecord record);
}
